package ar.edu.unlam.tallerweb1.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ArchivosUtils {
	
	public static String subirArchivo(MultipartFile archivo, String pathArchivo) throws IOException {
		crearDirectorio(pathArchivo);
		if(!archivo.isEmpty()) {
			try {
				byte[] bytes = archivo.getBytes();
				String[] parts = archivo.getOriginalFilename().split("\\.");
				String extension = parts[parts.length-1];
				final String newName = UUID.randomUUID().toString() + "."+extension;
				String ruta = pathArchivo + newName;
				Path path = Paths.get(ruta);
				Files.write(path, bytes);
				return ruta;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static Path crearDirectorio(String path) throws IOException {
		try {
			if(Files.notExists(Paths.get(path))) {
				return Files.createDirectories(Paths.get(path));
			}
		} catch (IOException e) {
			throw new IOException("Verifique que exita la carpeta: " + path);
		}
		
		return null;
	}
}
