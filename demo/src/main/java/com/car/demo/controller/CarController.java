package com.car.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.car.demo.dao.CarDao;
import com.car.demo.model.Car;

@CrossOrigin(origins="http://localhost:4200")
@Controller
public class CarController {
	
	@Autowired
	CarDao cd;

	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<List<Car>> getallinfo(){
		return new ResponseEntity<>(cd.getall(),HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public ResponseEntity<Object> addItem(@RequestBody Car c){
		String msg=" ";
		if(cd.addCar(c.getName(), c.getModel())>=1) {
			msg="Data Saved Successfully";
		}else {
			msg="Save Error";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}
