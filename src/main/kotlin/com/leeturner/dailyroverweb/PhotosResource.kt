package com.leeturner.dailyroverweb

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.leeturner.dailyroverweb.api.model.photo.PhotoResponse
import io.quarkus.qute.Template
import io.quarkus.qute.TemplateInstance
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/")
class PhotosResource {
    
    @Inject
    private lateinit var objectMapper: ObjectMapper
    
    @Inject
    lateinit var photos: Template
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    fun get(): TemplateInstance {
        val json = this::class.java.getResourceAsStream("/examples/photos.json")!!.bufferedReader().use { it.readText() }
        val photoResponse: PhotoResponse = objectMapper.readValue(json)
        return photos.data("marsPhotos", photoResponse, "formattedEarthDate", photoResponse.earthDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)))
    }
}