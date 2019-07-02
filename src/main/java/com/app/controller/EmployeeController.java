package com.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.ReaderConfig;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.xml.sax.SAXException;

import com.app.model.Employee;
import com.app.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository repository;

	@Autowired
	private ResourceLoader resourceLoader;

	@GetMapping("/helloo")
	public String hello1() {
		return "hello";
	}

	//consumes = MediaType.MULTIPART_FORM_DATA_VALUE
	@PostMapping(value="/hello")
	public String hello(@RequestBody @RequestParam MultipartFile file) throws SAXException, InvalidFormatException {

		/*
		  repository.saveAll(empLst());
		  repository.deleteAll();
		 */

		try {
			
			String xmlPath = "classpath:employee.xml";

			Resource config = resourceLoader.getResource(xmlPath);

			ReaderConfig.getInstance().setSkipErrors(true);
			XLSReader xlsReader = ReaderBuilder.buildFromXML(config.getInputStream());

			List<Employee> emplst = new ArrayList<>();
			Map<String, List<Employee>> beans = new HashMap<>();
			beans.put("emplist", emplst);

			XLSReadStatus status = xlsReader.read(file.getInputStream(), beans);

			if (status.isStatusOK()) {

				List<Employee> emplist = beans.get(emplst);
				System.out.println(emplist.size());
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
		System.out.println();
		return "success ";
	}

	public List<Employee> empLst() {
		List<Employee> emplst = new ArrayList<Employee>();

		Employee e1 = new Employee("ABC", "abc@gmail.com", "1234567891", 3.1);
		Employee e2 = new Employee("ABC", "abc@gmail.com", "1234567892", 3.2);
		Employee e3 = new Employee("ABD", "abd@gmail.com", "1234567893", 3.3);
		Employee e4 = new Employee("ABE", "abe@gmail.com", "1234567894", 3.4);
		Employee e5 = new Employee("ABF", "abf@gmail.com", "1234567895", 3.5);
		Employee e6 = new Employee("ABG", "abg@gmail.com", "1234567896", 3.6);
		Employee e7 = new Employee("ABH", "abh@gmail.com", "1234567897", 3.7);
		Employee e8 = new Employee("ABI", "abi@gmail.com", "1234567898", 3.8);
		Employee e9 = new Employee("ABJ", "abj@gmail.com", "1234567899", 3.9);

		emplst.add(e1);
		emplst.add(e2);
		emplst.add(e3);
		emplst.add(e4);
		emplst.add(e5);
		emplst.add(e6);
		emplst.add(e7);
		emplst.add(e8);
		emplst.add(e9);

		return emplst;
	}

}
