package com.retail.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class GenericMapper<E, D> {

    protected ModelMapper mapper;
    private final Class<E> entityClass;
    private final Class<D> dtoClass;

    protected GenericMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Autowired
    public void setMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public E toEntity(D dto) {
        return Objects.isNull(dto)
                ? null
                : mapper.map(dto, entityClass);
    }

    public List<E> toEntities(List<D> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public D toDto(E entity) {
        return Objects.isNull(entity)
                ? null
                : mapper.map(entity, dtoClass);
    }

    public List<D> toDtos(List<E> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    Converter<D, E> toEntityConverter() {
        return context -> {
            D source = context.getSource();
            E destination = context.getDestination();
            mapSpecificFieldsDtoToEntity(source, destination);
            return context.getDestination();
        };
    }

    public Converter<E, D> toDtoConverter() {
        return context -> {
            E source = context.getSource();
            D destination = context.getDestination();
            mapSpecificFieldsEntityToDto(source, destination);
            return context.getDestination();
        };
    }

    protected void mapSpecificFieldsDtoToEntity(D source, E destination) {}

    protected void mapSpecificFieldsEntityToDto(E source, D destination) {}

}