package uh.ahci.images;

import java.io.ByteArrayInputStream;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * This class represents an Image that is created from a blob.
 */
public class Image {
	
	/** The bitmap of the image */
	public Bitmap _bitmap = null;

	/**
	 * Constructor.
	 * @param filename The filename of the image.
	 */
	public Image(String filename) {
		_bitmap = BitmapFactory.decodeFile(filename);
	}
	
	/**
	 * Constructor.
	 * @param res The resources of the application.
	 * @param id The resource id.
	 */
	public Image(Resources res, int id) {
		_bitmap = BitmapFactory.decodeResource(res, id);
	}
	/**
	 * Constructor.
	 * @param blob The byte array that needs to be decoded to a bitmap.
	 */
	public Image(byte[] blob) {
		_bitmap = BitmapFactory.decodeByteArray(blob, 0, blob.length);
	}
	
	/**
	 * Constructor.
	 * @param blob The byte array stream that needs to be decoded to a bitmap.
	 */
	public Image(ByteArrayInputStream blob) {
		_bitmap = BitmapFactory.decodeStream(blob);
	}
	
	/**
	 * Get the bitmap of the image.
	 * @return The bitmap of the image.
	 */
	public Bitmap getBitmap() {
		return _bitmap;
	}
}
