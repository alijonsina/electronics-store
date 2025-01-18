package dao;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ItemObjectOutputStream extends ObjectOutputStream {

	public ItemObjectOutputStream(OutputStream out)throws IOException
	{
		super(out);
		
	}
	@Override 
	protected void writeStreamHeader() throws IOException
	{
		
	}
	
}
	
