package com.jcode_development.store.mapper;

import org.modelmapper.ModelMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Mapper {
	
	private static final ModelMapper mapper = new ModelMapper();
	
	public static <O , D> D parseObject(O origin, Class<D> destination){
		return mapper.map(origin, destination);
	}
	
	public static <O, D> Set<D> parseObjects(List<O> origin, Class<D> destination){
		Set<D> destinationObjects = new HashSet<>();
		for(O o: origin){
			destinationObjects.add(mapper.map(o , destination));
		}
		return destinationObjects;
	}
}
