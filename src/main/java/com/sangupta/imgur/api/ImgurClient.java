/**
 *
 * imgur-client: Java Client for imgur.com API
 * Copyright (c) 2014, Sandeep Gupta
 * 
 * http://sangupta.com/projects/imgur-client
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
 * A strongly-typed client that helps access various end points of
 * the imgur.com API.
 * 
 * @author sangupta
 *
 */
public class ImgurClient {
	
	/**
	 * The base URL for version 3 of the API
	 */
	public static final String BASE_URI = "https://api.imgur.com/3/";
	
	/**
	 * The clientID as provided by imgur
	 */
	private String clientID;
	
	/**
	 * The client secret as provided by imgur
	 */
	private String clientSecret;
	
	/**
	 * Construct a new {@link ImgurClient} for the given key and secret.
	 * 
	 * @param clientID
	 * @param clientSecret
	 */
	public ImgurClient(String clientID, String clientSecret) {
		this.clientID = clientID;
		this.clientSecret = clientSecret;
	}
	
	// ------------------------------
	// ALBUM METHODS
	// ------------------------------
	
	/**
	 * Get the album details for the given album ID.
	 * 
	 * @param id
	 *            the id of the album
	 * 
	 * @return the {@link AlbumWrapper} instance containing the details
	 */
	public AlbumWrapper getAlbumDetails(String id) {
		return get("/album/" + id, AlbumWrapper.class);
	}

	// ------------------------------
	// GALLERY METHODS
	// ------------------------------

	/**
	 * Get the gallery details for the given gallery ID.
	 * 
	 * @param id
	 *            the id of the gallery
	 * 
	 * @return the {@link GalleryAlbumWrapper} instance containing the details
	 */
	public GalleryAlbumWrapper getGalleryAlbum(String id) {
		return get("/gallery/album/" + id, GalleryAlbumWrapper.class);
	}

	/**
	 * Get details of the given gallery image.
	 * 
	 * @param id
	 *            the id of the gallery image
	 * 
	 * @return the {@link GalleryImageWrapper} instance containing the details
	 */
	public GalleryImageWrapper getGalleryImage(String id) {
		return get("/gallery/image/" + id, GalleryImageWrapper.class);
	}


	// ------------------------------
	// USEFUL ABSTRACTIONS
	// ------------------------------
	
	/**
	 * Hit the base url and parse the response into the given class type
	 * instance
	 * 
	 * @param path
	 *            the URL to hit
	 * 
	 * @param classOfT
	 *            the object type into which the details need to be populated
	 * 
	 * @return the instance of the type with populated details
	 */
	protected <T> T get(String path, Class<T> classOfT) {
		String url = UriUtils.addWebPaths(BASE_URI, path + ".json");
		WebRequest request = WebInvoker.getWebRequest(url, WebRequestMethod.GET);
		return invoke(request, classOfT);
	}
	
	/**
	 * Execute the given {@link WebRequest} and populate the result parsing JSON
	 * response into the given object type
	 * 
	 * @param request
	 *            the {@link WebRequest} to execute
	 * 
	 * @param classOfT
	 *            the object type into which the details need to be populated
	 * 
	 * @return the instance of the type with populated details
	 * 
	 */
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
