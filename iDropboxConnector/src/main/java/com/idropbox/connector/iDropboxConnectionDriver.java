package com.idropbox.connector;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.WebAuthSession;
import com.dropbox.client2.session.Session.AccessType;



public class iDropboxConnectionDriver {
	
	private  String APP_KEY = "";
    private  String APP_SECRET = "";
    
    private DropboxAPI<WebAuthSession> webAuthSession;
    

	public DropboxAPI<WebAuthSession> getWebAuthSession() {
		return webAuthSession;
	}


	public void setWebAuthSession(DropboxAPI<WebAuthSession> webAuthSession) {
		this.webAuthSession = webAuthSession;
	}


	public iDropboxConnectionDriver(String ACCESS_TOKEN_KEY,String ACCESS_TOKEN_SECRET,String APP_KEY,String APP_SECRET){
		this.APP_KEY=APP_KEY;
		this.APP_SECRET=APP_SECRET;
		getDropboxConnection(ACCESS_TOKEN_KEY,ACCESS_TOKEN_SECRET);
	}
	
	
	private void getDropboxConnection(String APP_KEY,String APP_SECRET){
		getDropBoxSession(APP_KEY,APP_SECRET);
	}
	
	/**
	 * Get dropbox session
	 * @return
	 */
	public void getDropBoxSession(String accessKey,String accessSecret){
		AccessType ACCESS_TYPE = AccessType.DROPBOX;
        AppKeyPair appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
        WebAuthSession session = new WebAuthSession(appKeys, ACCESS_TYPE);
        // Initialize DropboxAPI object
        DropboxAPI<WebAuthSession> mDBApi =new DropboxAPI<WebAuthSession>(session);
       //Re-auth
        AccessTokenPair reAuthTokens = new AccessTokenPair(accessKey,accessSecret);//Re-auth
		mDBApi.getSession().setAccessTokenPair(reAuthTokens);
		setWebAuthSession(mDBApi);
	}
	
	
}
