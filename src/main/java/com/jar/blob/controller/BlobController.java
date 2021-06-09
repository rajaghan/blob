package com.jar.blob.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlobController {

	@Autowired
	public JdbcTemplate jdbcTemplate;

	@GetMapping(path = "/hello")
	public String sayHello() {
		return "hola";

	}

	@GetMapping(path = "/data")
	public void readBlob() throws SQLException, IOException {

		Blob myblob = jdbcTemplate.queryForObject("select logo from company", Blob.class);

		InputStream byte_stream = myblob.getBinaryStream();

		File file = new File("output.png");

		OutputStream fos;

		fos = new FileOutputStream(file);
		
		byte[] b = new byte[1024];
		
		int len = 0;
		
		while ((len = byte_stream.read(b)) != -1) {
			fos.write(b, 0, len);
		}
		
		fos.close();
		byte_stream.close();

	}
}
