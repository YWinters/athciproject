package uh.ahci.wallet.card;

import java.util.ArrayList;

import uh.ahci.exceptions.CardException;
import uh.ahci.people.User;
import uh.ahci.store.StoreChain;
import uh.ahci.store.coupon.Coupon;

/**
 * This class represents a loyalty card that contains several coupons. 
 * @author Seppe Magiels
 */
public class CouponCard extends Card {
	
	/** A list containing all the different coupons that are valid for the store. */
	private ArrayList<Coupon> _coupons = new ArrayList<Coupon>();

	/**
	 * Constructor.
	 * @param store The data of the store chain.
	 * @param owner The data of the card owner.
	 * @throws CardException 
	 */
	public CouponCard(StoreChain store, User owner) throws CardException {
		super(store, owner);
	}

	/**
	 * Constructor.
	 * @param store The data of the store chain.
	 * @param owner The data of the card owner.
	 * @param coupons The list containing all the different coupons that are valid for the store.
	 * @throws CardException 
	 */
	public CouponCard(StoreChain store, User owner, ArrayList<Coupon> coupons) throws CardException {
		this(store, owner);
		setCoupons(coupons);
	}

	/**
	 * Set the given set of coupons for the loyalty card.
	 * @param coupons The new set of coupons.
	 * @throws CardException 
	 */
	public void setCoupons(ArrayList<Coupon> coupons) throws CardException {
		if(coupons == null)
			throw(new CardException("The coupon list can't be null!"));
		_coupons.clear();
		for(Coupon coupon : coupons)
			addCoupon(coupon);
	}
	
	/**
	 * Add the given coupon to the list of available coupons.
	 * @param coupon The coupon that needs to be added.
	 * @throws CardException 
	 */
	public void addCoupon(Coupon coupon) throws CardException {
		if(coupon == null)
			throw(new CardException("The coupon can't be null!"));
		_coupons.add(coupon);
	}
	
	/**
	 * Remove the given coupon from the list of available coupons.
	 * @param coupon The coupon that needs to be removed.
	 * @throws CardException 
	 */
	public void removeCoupon(Coupon coupon) throws CardException {
		if(coupon == null)
			throw(new CardException("The coupon can't be null!"));
		_coupons.remove(coupon);
	}
	
	/**
	 * Get a string containing extra info about the card.
	 * @return String containing extra info.
	 */
	public String getExtraInfo() {
		return _coupons.size()+" coupons available";
	}
}
