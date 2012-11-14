package uh.ahci.wallet.card;

import uh.ahci.exceptions.CardException;
import uh.ahci.people.User;
import uh.ahci.store.StoreChain;

/** 
 * This class represents an abstract loyaltyCard.
 * @author Seppe Magiels
 */
public abstract class Card {

	/** The store chain. */
	protected StoreChain _store;
	/** The owner of the loyalty card. */
	protected User _owner;
	
	/**
	 * Constructor.
	 * @param store The data of the store chain.
	 * @param owner The data of the card owner.
	 * @throws CardException 
	 */
	protected Card(StoreChain store, User owner) throws CardException {
		setStore(store);
		setOwner(owner);
	}

	/**
	 * Set the store of the loyalty card. 
	 * @param store The new store of the card.
	 * @throws CardException 
	 */
	public void setStore(StoreChain store) throws CardException {
		if(store == null)
			throw(new CardException("The store chain can't be null!"));
		_store = store;
	}

	/**
	 * Set the owner of the loyalty card. 
	 * @param owner The new owner of the card.
	 * @throws CardException 
	 */
	public void setOwner(User owner) throws CardException {
		if(owner == null)
			throw(new CardException("The owner can't be null!"));
		_owner = owner;
	}

	/**
	 * Get the store of the loyalty card. 
	 * @return The store of the loyalty card.
	 */
	public StoreChain getStore() {
		return _store;
	}

	/**
	 * Get the owner of the loyalty card. 
	 * @return The owner of the loyalty card.
	 */
	public User getOwner() {
		return _owner;
	}
	
	/**
	 * Get the QR code that represents the loyalty card.
	 * @return The QR code.
	 */
	public void getQRCode() {
		
	}
	
	/**
	 * Get a string containing extra info about the card.
	 * @return String containing extra info.
	 */
	public abstract String getExtraInfo();
}
