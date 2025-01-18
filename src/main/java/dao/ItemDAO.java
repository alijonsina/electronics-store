package dao;



import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import Model.Item;


public class ItemDAO {

	private static final File ITEMS_FILE = new File("src/file_handling/items.dat");
	
	public static boolean addItem(Item item) {
		try(FileOutputStream outputStream = new FileOutputStream(ITEMS_FILE, true)) {
			ObjectOutputStream writer;
			
			if (ITEMS_FILE.length()>0) {
				writer = new ItemObjectOutputStream(outputStream);
			} else {
				writer = new ObjectOutputStream(outputStream);
			}
			writer.writeObject(item);
			writer.close();
			return true;
		} catch (IOException ex) {
			System.out.println("Error adding item to file: " + ex.getMessage());
			return false;
		}
	}
	
	
	public static Item searchItems(int id)
	{
		try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(ITEMS_FILE))) {
			while(true) {
				try {
					Item item = (Item) reader.readObject();
					if(item.getItemID() == id) {
						return item;
					}
					
					} catch (EOFException e) {
						break;
				}
			}
		} catch(IOException | ClassNotFoundException e) {
			System.out.println("Error reading file" +e.getMessage());
		}
		
		return null;
	}
	
	public static boolean deleteItems(int id) throws FileOperationException
	{
		if(!ITEMS_FILE.exists() || ITEMS_FILE.length() == 0)
		{
			throw new FileOperationException("File does not exist or is empty");
		}
		
		boolean itemDeleted = false;
		File tempfile = new File("src/file_handling/temp_items.dat");
		
		try(
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream(ITEMS_FILE));
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(tempfile))
		) {
			while(true) {
				try {
					Item item = (Item) reader.readObject();
					if (item.getItemID() == id) {
						itemDeleted = true;
					} else {
						writer.writeObject(item);
					}
				} catch(EOFException e) {
					break;
				}
			}
			
		} catch(IOException | ClassNotFoundException e)
		{
			throw new FileOperationException("Error processing file: " + e.getMessage());
		}
		
		if(!itemDeleted) {
			if (tempfile.exists()) {
	            tempfile.delete();
	        }
			throw new FileOperationException("Item with ID "+id+" not found");
		}
		
	    try {
	        if (ITEMS_FILE.exists() && !ITEMS_FILE.delete()) {
	            throw new FileOperationException("Unable to delete the original file.");
	        }
	        if (!tempfile.renameTo(ITEMS_FILE)) {
	            throw new FileOperationException("Error replacing the original file. Debug paths:\n"
	                + "Original File: " + ITEMS_FILE.getAbsolutePath() + "\n"
	                + "Temp File: " + tempfile.getAbsolutePath());
	        }
	    } catch (SecurityException e) {
	        throw new FileOperationException("Security exception while replacing files: " + e.getMessage());
	    }
		
		return true;
	}
	
	public static boolean editItemField(int id, String field, Object newValue) throws FileOperationException {
		if(!ITEMS_FILE.exists() || ITEMS_FILE.length() == 0)
		{
			throw new FileOperationException("File does not exist or is empty");
			//return false;
		}
		
		boolean itemUpdated = false;
		File tempfile = new File("src/file_handling/temp_items.dat");
		
		try(
				ObjectInputStream reader = new ObjectInputStream(new FileInputStream(ITEMS_FILE));
				ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(tempfile))
			) {
			while(true) {
				try {
					Item item = (Item) reader.readObject();
					if(item.getItemID() == id) {
	                    switch (field.toLowerCase()) {
                        case "name":
                            item.setName((String) newValue);
                            break;
                        case "cost":
                            item.setCost((int) newValue);
                            break;
                        case "retailprice":
                            item.setRetailPrice((int) newValue);
                            break;
                        case "sectorcode":
                            item.setSectorCode((int) newValue);
                            break;
                        case "sid":
                            item.setSId((int) newValue);
                            break;
                        case "nrofstock":
                            item.setNrOfStock((int) newValue);
                            break;
                        default:
                            throw new FileOperationException("Invalid field name: " + field);
	                    }
	                    itemUpdated = true;
					}
					writer.writeObject(item);
				} catch (EOFException e) {
					break;
				}
			}
			
		} catch (IOException | ClassNotFoundException e) {
			throw new FileOperationException("Error proccessing file: "+e.getMessage());
		}
		
		if (!itemUpdated) {
		    if (tempfile.exists()) {
		        tempfile.delete(); // Clean up temp file if no item was updated
		    }
		    throw new FileOperationException("Item with ID " + id + " not found.");
		}

		try {
		    // Ensure the original file is deleted before renaming
		    if (ITEMS_FILE.exists() && !ITEMS_FILE.delete()) {
		        throw new FileOperationException("Unable to delete the original file.");
		    }
		    if (!tempfile.renameTo(ITEMS_FILE)) {
		        throw new FileOperationException("Error replacing original file.");
		    }
		} catch (SecurityException e) {
		    throw new FileOperationException("Security exception: " + e.getMessage());
		}
		
		return true;
		
	}

}

