package com.example.demo.hello;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;


@Mapper(componentModel = "spring", uses = {})
public interface CarMapper{

	public Car toEntity(CarDto car);

	
	@Mappings({
		@Mapping(source = "numberOfSeats", target = "seatCount"),
		@Mapping(target = "name", source = "engine.name"),
		@Mapping(target = "company", source = "engine.company"),
		@Mapping(target = "power", source = "engine.power")})
	public CarDto toDto(Car entity);
	
}
