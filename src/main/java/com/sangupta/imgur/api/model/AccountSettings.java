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
 * Value object containing account setting details.
 * 
 * @author sangupta
 *
 */
public class AccountSettings {
	
	public String email;
	
	public boolean highQuality;
	
	public boolean publicImages;
	
	public String albumPrivacy;
	
	public String proExpiration;
	
	public boolean acceptedGalleryTerms;
	
	public List<String> activeEmails;
	
	public boolean messagingEnabled;
	
	public List<BlockedUser> blockedUsers;

}
