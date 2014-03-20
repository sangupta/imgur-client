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
 * Value object containing account details.
 * 
 * @author sangupta
 *
 */
public class Account implements Comparable<Account> {
	
	public long id;
	
	public String url;

	public String bio;
	
	public double reputation;
	
	public long created;
	
	public String proExpiration;

	@Override
	public String toString() {
		return "Imgur Album: " + this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Account)) {
			return false;
		}
		
		Account other = (Account) obj;
		return this.id == other.id;
	}
	
	@Override
	public int hashCode() {
		return (int)(this.id ^ (this.id >>> 32));
	}

	public int compareTo(Account other) {
		if(other == null) {
			return -1;
		}
		
		return (int) (this.id - other.id);
	}
}
