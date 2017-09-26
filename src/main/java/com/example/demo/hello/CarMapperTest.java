package com.example.demo.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarMapperTest {
	
	@Autowired
	private CarMapper  carMapper;
	
	public void shouldMapCarToDTO() {
		
		Car car = new Car();
		car.setMake("Jubin");
		car.setNumberOfSeats(5);
		car.setType(CarType.SEDAN);
		car.setPassanger("5");
		car.setModel("VDI");
		
		Engine engine = new Engine();
		engine.setName("HP");
		engine.setCompany("Sony");
		engine.setPower(1000);
		
		car.setEngine(engine);
		
//		Car car1 = carMapper.toEntity(car);
		
		CarDto carDto =  carMapper.toDto(car);
		
		System.out.println(carDto.getMake());
		System.out.println(carDto.getSeatCount());
		System.out.println(carDto.getType());
		System.out.println(carDto.getPassanger());
		System.out.println(carDto.getModel());
		System.out.println(carDto.getName());
		System.out.println(carDto.getCompany());
		System.out.println(carDto.getPower());
	}

}
