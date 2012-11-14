package uh.ahci.db.handler;

import uh.ahci.db.LocalDb;
import uh.ahci.db.RemoteDb;
import android.database.sqlite.SQLiteDatabase;

/**
 * The database handler of the local database.
 * @author Seppe Magiels
 */
public class SyncHandler {

	protected RemoteDb _remote = null;
	protected SQLiteDatabase _local = null;
	
	/**
	 * Constructor.
	 * @param remote The remote database.
	 * @param local The sqlite database.
	 */
	public SyncHandler(RemoteDb remote, LocalDb local) {
		assert remote != null : "Remote database can't be null!";
		assert local != null : "Local database can't be null!";
		_remote = remote;
		_local = local.getWritableDatabase();
	}
}
