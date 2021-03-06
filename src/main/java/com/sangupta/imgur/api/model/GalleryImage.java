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

package com.sangupta.imgur.api.model;

/**
 * Value object containing gallery image.
 * 
 * @author sangupta
 *
 */
public class GalleryImage {
	
	public String id;
	
	public String title;
	
	public String description;
	
	public long datetime;
	
	public String type;
	
	public boolean animated;
	
	public int width;
	
	public int height;
	
	public long size;
	
	public long views;
	
	public long bandwidth;
	
	public String deletehash;
	
	public String link;
	
	public String vote;
	
	public String section;
	
	public String accountUrl;
	
	public int ups;
	
	public int downs;

	public long score;
	
	public boolean isAlbum;

	/**
	 * 
	 * @author sangupta
	 *
	 */
	public static class GalleryImageWrapper extends AbstractWrapperModel<GalleryImage> {
		
	}
}
