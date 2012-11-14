package uh.ahci.wallet;

import java.util.ArrayList;

import android.content.Context;

import uh.ahci.R;
import uh.ahci.exceptions.CardException;
import uh.ahci.exceptions.StoreException;
import uh.ahci.images.Image;
import uh.ahci.people.User;
import uh.ahci.store.StoreChain;
import uh.ahci.wallet.card.Card;
import uh.ahci.wallet.card.PointCard;

/**
 * This class represents the wallet that contains all the loyalty cards.
 * @author Seppe Magiels
 */
public class Wallet {

	/** The Wallet instance. */
	public static Wallet _instance = null;
	/** The cards in the wallet. */
	private ArrayList<Card> _cards = new ArrayList<Card>();
	
	/**
	 * Constructor.
	 */
	private Wallet() {
		try {
			Image[] images = new Image[2];
			//images[0] = new Image(Context.getResources(), R.raw.flashlight_turn_off_icon);
			//images[1] = new Image(Context.getResources(), R.raw.flashlight_turn_on_icon);
			for(int i=1; i<=99; ++i)
				_cards.add(new PointCard(new StoreChain(i, ("Store "+i), images[i%2]), User.instance()));
		} catch (CardException e) {
			e.printStackTrace();
		} catch (StoreException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create a new Wallet if there doesn't exist one yet.
	 * @return The Wallet instance.
	 */
	public static Wallet instance() {
		if(_instance == null)
			_instance = new Wallet();
		return _instance;
	}
	
	/**
	 * Get the loyalty cards that are located in the wallet.
	 * @return The list of loyalty cards.
	 */
	public ArrayList<Card> getLoyaltyCards() {
		return _cards;
	}
}
