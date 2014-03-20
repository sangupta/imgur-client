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

import java.util.List;

/**
 * Value object containing details about a comment.
 * 
 * @author sangupta
 *
 */
public class Comment {
	
	public String id;
	
	public String imageId;
	
	public String caption;
	
	public String author;
	
	public long authorId;
	
	public boolean onAlbum;
	
	public String albumCover;
	
	public int ups;
	
	public int downs;
	
	public double points;
	
	public long datetime;
	
	public long parentId;
	
	public boolean deleted;
	
	public List<Comment> children;

}
