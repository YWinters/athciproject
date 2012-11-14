package uh.ahci.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * This class represents a SQLite database, used for local storage of the data.
 * 
 * @author Seppe Magiels
 */
public class LocalDb extends SQLiteOpenHelper {

	private static int VERSION = 3;

	public LocalDb(Context context, String name) {
		this(context, name, null);
	}
	
	public LocalDb(Context context, String name, CursorFactory factory) {
		super(context, name, factory, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS `storeChain` ("+
					"`id` INTEGER NOT NULL,"+
					"`name` TEXT(127) NOT NULL,"+
					"`cardUse` TEXT(255) NOT NULL DEFAULT POINTS,"+
					"PRIMARY KEY (`id`) "+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `store` ("+
					"`id` INTEGER NOT NULL,"+
					"`chain` INTEGER NOT NULL,"+
					"`address` INTEGER NOT NULL,"+
					"`gps` INTEGER NOT NULL,"+
					"PRIMARY KEY (`id`) ,"+
					"CONSTRAINT `chainOfStore` FOREIGN KEY (`chain`) REFERENCES `storeChain` (`id`),"+
					"CONSTRAINT `storeAddress` FOREIGN KEY (`address`) REFERENCES `address` (`id`),"+
					"CONSTRAINT `locationOfStore` FOREIGN KEY (`gps`) REFERENCES `gpsCoor` (`id`)"+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `country` ("+
					"`iso` TEXT(3) NOT NULL,"+
					"`name` TEXT(127) NOT NULL,"+
					"PRIMARY KEY (`iso`) "+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `address` ("+
					"`id` INTEGER NOT NULL,"+
					"`street` TEXT(127) NOT NULL,"+
					"`number` INTEGER NOT NULL,"+
					"`box` TEXT(3) DEFAULT NULL,"+
					"`postalCode` TEXT(9) NOT NULL,"+
					"`city` TEXT(63) NOT NULL,"+
					"`cIso` TEXT(3) NOT NULL,"+
					"PRIMARY KEY (`id`) ,"+
					"CONSTRAINT `countryIso` FOREIGN KEY (`cIso`) REFERENCES `country` (`iso`)"+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `user` ("+
					"`id` INTEGER NOT NULL,"+
					"`lastName` TEXT(63) NOT NULL,"+
					"`firstName` TEXT(63) NOT NULL,"+
					"PRIMARY KEY (`id`) ,"+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `loyaltyCard` ("+
					"`id` INTEGER NOT NULL,"+
					"`chain` INTEGER NOT NULL,"+
					"`costumer` INTEGER NOT NULL,"+
					"PRIMARY KEY (`id`) ,"+
					"CONSTRAINT `cardForStore` FOREIGN KEY (`chain`) REFERENCES `storeChain` (`id`),"+
					"CONSTRAINT `cardOwner` FOREIGN KEY (`costumer`) REFERENCES `user` (`id`)"+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `gpsCoor` ("+
					"`id` INTEGER NOT NULL,"+
					"`lat` REAL(10,6) NOT NULL,"+
					"`lng` REAL(10,6) NOT NULL,"+
					"PRIMARY KEY (`id`) "+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `childCards` ("+
					"`master` INTEGER NOT NULL,"+
					"`costumer` INTEGER NOT NULL,"+
					"`expirationDate` TEXT DEFAULT NULL,"+
					"PRIMARY KEY (`master`) ,"+
					"CONSTRAINT `childCardOf` FOREIGN KEY (`master`) REFERENCES `loyaltyCard` (`id`),"+
					"CONSTRAINT `cCardOwner` FOREIGN KEY (`costumer`) REFERENCES `user` (`id`)"+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `cardPoints` ("+
					"`card` INTEGER NOT NULL,"+
					"`points` INTEGER NOT NULL DEFAULT 0,"+
					"PRIMARY KEY (`card`) ,"+
					"CONSTRAINT `pointsOfCard` FOREIGN KEY (`card`) REFERENCES `loyaltyCard` (`id`)"+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `chainCoupon` ("+
					"`chain` INTEGER NOT NULL,"+
					"`product` INTEGER DEFAULT NULL,"+
					"`amount` INTEGER NOT NULL,"+
					"`discount` REAL NOT NULL,"+
					"`expirationDate` TEXT NOT NULL,"+
					"PRIMARY KEY (`chain`, `product`) ,"+
					"CONSTRAINT `couponForChain` FOREIGN KEY (`chain`) REFERENCES `storeChain` (`id`),"+
					"CONSTRAINT `couponForProduct` FOREIGN KEY (`product`) REFERENCES `product` (`id`)"+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `product` ("+
					"`id` INTEGER NOT NULL,"+
					"`desc` TEXT(255) NOT NULL,"+
					"`price` REAL NOT NULL,"+
					"PRIMARY KEY (`id`) "+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `storeCoupon` ("+
					"`store` INTEGER NOT NULL,"+
					"`product` INTEGER DEFAULT NULL,"+
					"`amount` INTEGER NOT NULL,"+
					"`discount` REAL NOT NULL,"+
					"`expirationDate` TEXT NOT NULL,"+
					"PRIMARY KEY (`store`, `product`) ,"+
					"CONSTRAINT `sCouponForProduct` FOREIGN KEY (`product`) REFERENCES `product` (`id`),"+
					"CONSTRAINT `couponForStore` FOREIGN KEY (`store`) REFERENCES `store` (`id`)"+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `survey` ("+
					"`id` INTEGER NOT NULL,"+
					"`store` INTEGER NOT NULL,"+
					"`begin` TEXT NOT NULL,"+
					"`end` TEXT NOT NULL,"+
					"PRIMARY KEY (`id`) ,"+
					"CONSTRAINT `surveyOfStore` FOREIGN KEY (`store`) REFERENCES `store` (`id`)"+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `surveyQuestion` ("+
					"`id` INTEGER NOT NULL,"+
					"`survey` INTEGER NOT NULL,"+
					"`question` TEXT(255) NOT NULL,"+
					"PRIMARY KEY (`id`) ,"+
					"CONSTRAINT `questionOfSurvey` FOREIGN KEY (`survey`) REFERENCES `survey` (`id`)"+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `surveyOptions` ("+
					"`id` INTEGER NOT NULL,"+
					"`question` INTEGER NOT NULL,"+
					"`option` TEXT(63) NOT NULL,"+
					"PRIMARY KEY (`id`) ,"+
					"CONSTRAINT `optionForQuestion` FOREIGN KEY (`question`) REFERENCES `surveyQuestion` (`id`)"+
				")");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS `surveyAnswer` ("+
					"`id` INTEGER NOT NULL,"+
					"`question` INTEGER NOT NULL,"+
					"`option` INTEGER,"+
					"PRIMARY KEY (`id`) ,"+
					"CONSTRAINT `questionAnswer` FOREIGN KEY (`question`) REFERENCES `surveyQuestion` (`id`),"+
					"CONSTRAINT `answerOnQuestion` FOREIGN KEY (`option`) REFERENCES `surveyOptions` (`id`)"+
				")");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}
