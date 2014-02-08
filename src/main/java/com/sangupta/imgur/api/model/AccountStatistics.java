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

package com.sangupta.imgur.api.model;

import java.util.List;

/**
 * 
 * @author sangupta
 *
 */
public class AccountStatistics {

	public long totalImages;
	
	public long totalAlbums;
	
	public String diskUsed;
	
	public String bandwidthUsed;
	
	public List<Image> topImages;
	
	public List<Album> topAlbums;
	
	public List<Comment> topGalleryComments;
	
}
