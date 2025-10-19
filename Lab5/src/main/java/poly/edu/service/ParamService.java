package poly.edu.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ParamService {
	@Autowired
	private HttpServletRequest request;

	public String getString(String name, String defaultValue) {
		String value = request.getParameter(name);
		return value != null ? value : defaultValue;
	}

	public int getInt(String name, int defaultValue) {
		String value = request.getParameter(name);
		return value != null ? Integer.parseInt(value) : defaultValue;
	}

	public double getDouble(String name, double defaultValue) {
		String value = request.getParameter(name);
		return value != null ? Double.parseDouble(value) : defaultValue;
	}

	public boolean getBoolean(String name, boolean defaultValue) {
		String value = request.getParameter(name);
		return value != null ? Boolean.parseBoolean(value) : defaultValue;
	}

	public Date getDate(String name, String pattern) {
		String value = request.getParameter(name);
		if (value != null) {
			try {
				SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
				return dateFormat.parse(value);
			} catch (ParseException e) {
				throw new RuntimeException("Invalid date format");
			}
		}
		return null;
	}

	public File save(MultipartFile file, String path) {
		if (!file.isEmpty()) {
			try {
				String filename = file.getOriginalFilename();
				String filepath = path + File.separator + filename;
				File destination = new File(filepath);
				file.transferTo(destination);
				return destination;
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("Error saving file");
			}
		}
		return null;
	}
}
