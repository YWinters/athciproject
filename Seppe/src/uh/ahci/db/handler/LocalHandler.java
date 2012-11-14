package uh.ahci.db.handler;

import uh.ahci.db.LocalDb;
import android.database.sqlite.SQLiteDatabase;

/**
 * The database handler of the local database.
 * @author Seppe Magiels
 */
public class LocalHandler {
	
	protected SQLiteDatabase _db = null;
	
	/**
	 * Constructor.
	 * @param db The sqlite database.
	 */
	public LocalHandler(LocalDb db) {
		assert db != null : "Database can't be null!";
		_db = db.getWritableDatabase();
	}
}
