package uh.ahci.store.coupon;

import uh.ahci.exceptions.CouponException;
import uh.ahci.store.product.Product;

/**
 * This class represents a coupon.
 * @author Seppe Magiels
 */
public class Coupon {

	/** The product the coupon is for. */
	private Product _product;
	/** The amount of the product that has to be bought before the coupon can be used. */
	private int _amount;
	/** The discount that the coupon offers. */
	private float _discount;
	/** Expiration date of the coupon. */
	private long _expirationDate;
	
	/**
	 * Constructor.
	 * @param product The product the coupon is used for.
	 * @param amount The amount of the product that has to be bought before the coupon can be used.
	 * @param discount The discount the coupon offers.
	 * @param expirationDate The expirationDate of the coupon.
	 * @throws CouponException 
	 */
	public Coupon(Product product, int amount, float discount, long expirationDate) throws CouponException {
		setProduct(product);
		setAmout(amount);
		setDiscount(discount);
		setExpirationDate(expirationDate);
	}

	/**
	 * Set the amount of the coupon.
	 * @param amount The amount of the product that has to be bought before the coupon can be used.
	 * @throws CouponException 
	 */
	public void setAmout(int amount) throws CouponException {
		if(amount <= 0)
			throw(new CouponException("The coupon's amount can't be less or equal to zero!"));
		_amount = amount;
	}

	/**
	 * Set the discount of the coupon.
	 * @param discount The discount that the coupon offers.
	 * @throws CouponException 
	 */
	public void setDiscount(float discount) throws CouponException {
		if(discount <= 0.0)
			throw(new CouponException("The coupon's discount can't be less or equal to zero!"));
		_discount = discount;
	}

	/**
	 * Set the expiration date of the coupon.
	 * @param expirationDate The expiration date of the coupon.
	 * @throws CouponException 
	 */
	public void setExpirationDate(long expirationDate) throws CouponException {
		if(expirationDate <= 0.0)
			throw(new CouponException("The coupon's expiration date can't be less or equal to zero!"));
		_expirationDate = expirationDate;
	}

	/**
	 * Check if the coupon can be applied with the given amount.
	 * @param product The product we need to compare with the coupon. 
	 * @param amount The amount of the product that is bought.
	 * @return True if it can be applied. False otherwise. 
	 */
	public boolean canBeApplied(Product product, int amount) {
		if(amount < _amount)
			return false;
		else if(!_product.equals(product))
			return false;
		else if(_expirationDate < System.currentTimeMillis())
			return false;
		return true;
	}
	
	/**
	 * Get the amount of the coupon.
	 * @return The amount.
	 */
	public int getAmount() {
		return _amount; 
	}
	
	/**
	 * Get the discount of the coupon.
	 * @return The discount.
	 */
	public float getDiscount() {
		return _discount; 
	}
	
	/**
	 * Get the expiration date of the coupon.
	 * @return The expiration date.
	 */
	public long getExpirationDate() {
		return _expirationDate; 
	}
	
	/**
	 * Set the product of the coupon.
	 * @param product The discount that the coupon offers.
	 * @throws CouponException 
	 */
	private void setProduct(Product product) throws CouponException {
		if(product == null)
			throw(new CouponException("The coupon's product can't be null!"));
		_product = product;
	}
}
