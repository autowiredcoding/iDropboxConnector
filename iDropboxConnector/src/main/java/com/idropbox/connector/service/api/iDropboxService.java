package com.idropbox.connector.service.api;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.DropboxAPI.Entry;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.WebAuthSession;
import com.idropbox.models.DropboxFileInfo;


public class iDropboxService {
	
	public List<DropboxFileInfo> listDropBoxFolders(String parentFolder,DropboxAPI<WebAuthSession> mDBApi) throws DropboxException, FileNotFoundException{
		System.out.println("parentFolder ="+parentFolder);
		List<DropboxFileInfo> dropBoxFolders=Collections.emptyList();
		try{
			DropboxFileInfo dbinfo=null;
			Entry entries = mDBApi.metadata(parentFolder, 20, null, true, null);
			dropBoxFolders=new ArrayList<DropboxFileInfo>();
			for (Entry e: entries.contents) {
				if(!e.isDeleted){
					if(e.isDir){
						dbinfo=new DropboxFileInfo(e.fileName(), null, 0);
						dropBoxFolders.add(dbinfo);
					} 
				}
			}
		}finally{
			
		}
		return dropBoxFolders;
	}

}
