/**
 *
 * imgur-client: Java Client for imgur.com API
 * Copyright (c) 2014, Sandeep Gupta
 * 
 * http://www.sangupta/projects/imgur-client
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package com.sangupta.imgur.api;

import org.apache.http.client.params.CookiePolicy;

import com.sangupta.imgur.api.model.Album.AlbumWrapper;
import com.sangupta.imgur.api.model.GalleryAlbum.GalleryAlbumWrapper;
import com.sangupta.imgur.api.model.GalleryImage.GalleryImageWrapper;
import com.sangupta.jerry.http.HttpHeaderName;
import com.sangupta.jerry.http.WebInvoker;
import com.sangupta.jerry.http.WebRequest;
import com.sangupta.jerry.http.WebRequestMethod;
import com.sangupta.jerry.http.WebResponse;
import com.sangupta.jerry.util.GsonUtils;
import com.sangupta.jerry.util.UriUtils;

/**
 * 
 * @author sangupta
 *
 */
public class ImgurClient {
	
	public static final String BASE_URI = "https://api.imgur.com/3/";
	
	private String clientID;
	
	private String clientSecret;
	
	public ImgurClient(String clientID, String clientSecret) {
		this.clientID = clientID;
		this.clientSecret = clientSecret;
	}
	
	// ------------------------------
	// ALBUM METHODS
	// ------------------------------
	
	public AlbumWrapper getAlbumDetails(String id) {
		return get("/album/" + id, AlbumWrapper.class);
	}

	// ------------------------------
	// GALLERY METHODS
	// ------------------------------

	public GalleryAlbumWrapper getGalleryAlbum(String id) {
		return get("/gallery/album/" + id, GalleryAlbumWrapper.class);
	}

	public GalleryImageWrapper getGalleryImage(String id) {
		return get("/gallery/image/" + id, GalleryImageWrapper.class);
	}


	// ------------------------------
	// USEFUL ABSTRACTIONS
	// ------------------------------
	
	protected <T> T get(String path, Class<T> classOfT) {
		String url = UriUtils.addWebPaths(BASE_URI, path + ".json");
		WebRequest request = WebInvoker.getWebRequest(url, WebRequestMethod.GET);
		return invoke(request, classOfT);
	}
	
	protected <T> T invoke(WebRequest request, Class<T> classOfT) {
		request.addHeader(HttpHeaderName.AUTHORIZATION, "Client-ID " + this.clientID).cookiePolicy(CookiePolicy.BEST_MATCH).followRedirects();
		
		WebResponse response = null;
		try {
			response = request.execute().webResponse();
		} catch(Exception e) {
			e.printStackTrace();	
		}
		
		if(response == null) {
			return null;
		}
		
		if(!response.isSuccess()) {
			return null;
		}
		
		return GsonUtils.getGson().fromJson(response.getContent(), classOfT);
	}

}
