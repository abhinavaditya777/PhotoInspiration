package com.example.photoinspiration.data

import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class UnsplashPhoto (

	@SerializedName("id") val id : String,
	@SerializedName("created_at") val created_at : String,
	@SerializedName("updated_at") val updated_at : String,
	@SerializedName("promoted_at") val promoted_at : String,
	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("color") val color : String,
	@SerializedName("blur_hash") val blur_hash : String,
	@SerializedName("description") val description : String,
	@SerializedName("alt_description") val alt_description : String,
	@SerializedName("urls") val urls : Urls,
	@SerializedName("links") val links : Links,
	@SerializedName("categories") val categories : List<String>,
	@SerializedName("likes") val likes : Int,
	@SerializedName("liked_by_user") val liked_by_user : Boolean,
	@SerializedName("current_user_collections") val current_user_collections : List<String>,
	@SerializedName("sponsorship") val sponsorship : Sponsorship,
	@SerializedName("user") val user : User

)