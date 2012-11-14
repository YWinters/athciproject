package uh.ahci.store;

import uh.ahci.exceptions.StoreException;
import uh.ahci.images.Image;

/**
 * This class represents a store chain.
 * @author Seppe Magiels
 */
public class StoreChain {
	
	/** The unique id of the store chain in the database. */
	protected int _id;
	/** The name of the store chain. */
	protected String _name;
	/** The id of the resource representing the logo. */
	protected Image _logo;
	
	/**
	 * Constructor.
	 * @param name The name of the store chain. E.g. Carrefour, Colruyt, ...
	 * @param logo The logo of the store chain.
	 */
	public StoreChain(int id, String name, Image logo) throws StoreException {
		_id = id;
		setName(name);
		setLogo(logo);
	}

	/**
	 * Set the name of the store chain. 
	 * @param name The new name of the store chain.
	 */
	public void setName(String name) throws StoreException {
		if(name == null)
			throw(new StoreException("The store chain name can't be null!"));
		_name = name;
	}

	/**
	 * Set the store logo. 
	 * @param logo The new logo of the store chain.
	 */
	public void setLogo(Image logo) throws StoreException {
		if(logo == null)
			throw(new StoreException("The logo can't be null!"));
		_logo = logo;
	}
	
	/**
	 * Get the name of the store chain.
	 * @return The name of the store chain.
	 */
	public String getName() {
		return _name;
	}

	/**
	 * Get the logo of the store chain.
	 * @return The logo of the store chain.
	 */
	public Image getLogo() {
		return _logo;
	}
}
