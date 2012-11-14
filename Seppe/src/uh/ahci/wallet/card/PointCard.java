package uh.ahci.wallet.card;

import uh.ahci.exceptions.CardException;
import uh.ahci.people.User;
import uh.ahci.store.StoreChain;

/**
 * This class represents a loyalty card that saves points for the user.
 * @author Seppe Magiels
 */
public class PointCard extends Card {

	/** The point balance of the loyalty card. */
	private int _points;

	/**
	 * Constructor.
	 * @param store The data of the store chain.
	 * @param owner The data of the card owner.
	 * @throws CardException 
	 */
	public PointCard(StoreChain store, User owner) throws CardException {
		this(store, owner, 0);
	}

	/**
	 * Constructor.
	 * @param store The data of the store chain.
	 * @param points The point balance of the loyalty card.
	 * @param owner The data of the card owner.
	 * @throws CardException 
	 */
	public PointCard(StoreChain store, User owner, int points) throws CardException {
		super(store, owner);
		setPoints(points);
	}

	/**
	 * Set the current point balance to the given amount of points.
	 * @param points The new amount of points.
	 */
	public void setPoints(int points) {
		_points = points;
		checkPoints();
	}
	
	/**
	 * Add the given amount of points to the current point balance.
	 * @param points The amount of points that needs to be added.
	 */
	public void addPoints(int points) {
		_points += points;
		checkPoints();
	}
	
	/**
	 * Check the amount of points to make sure it isn't a negative amount.
	 */
	private void checkPoints() {
		if(_points < 0)
			_points = 0;
	}
	
	/**
	 * Get a string containing extra info about the card.
	 * @return String containing extra info.
	 */
	public String getExtraInfo() {
		return _points+" points";
	}
}
