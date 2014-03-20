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

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import com.sangupta.imgur.api.model.Album.AlbumWrapper;
import com.sangupta.imgur.api.model.Image.ImageWrapper;
import com.sangupta.jerry.util.GsonUtils;

/**
 * @author sangupta
 *
 */
public class TestModels {

	@Test
	public void testImageResponse() {
		String json = readJson("image.json");
		
		ImageWrapper wrapper = GsonUtils.getGson().fromJson(json, ImageWrapper.class);
		Assert.assertNotNull(wrapper.data);
	}
	
	@Test
	public void testAlbumResponse() {
		String json = readJson("album.json");
		
		AlbumWrapper wrapper = GsonUtils.getGson().fromJson(json, AlbumWrapper.class);
		Assert.assertNotNull(wrapper.data);
	}
	
	private String readJson(String fileName) {
		try {
			String path = this.getClass().getClassLoader().getResource(fileName).getPath();
			return FileUtils.readFileToString(new File(path));
		} catch(IOException e) {
			
		}
		
		return null;
	}
}
