package com.lpgo.pepenet.server;

public class MultiClientMessage
{
	// region Variables
	private int[] clientIDs;
	private String msg;
	// endregion
	
	public MultiClientMessage ( int[] clientIDs, String msg )
	{
		this.clientIDs = clientIDs;
		this.msg = msg;
	}

	// region GettersNSetters
	public int[]  getClientIDs (                 ) { return clientIDs;           }
	public void   setClientIDs ( int[] clientIDs ) { this.clientIDs = clientIDs; }
	public String getMsg       (                 ) { return msg;                 }
	public void   setMsg       ( String msg      ) { this.msg = msg;             }
	// endregion
}
