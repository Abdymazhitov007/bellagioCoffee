package kg.bellagio.bellagiocoffee.mapper;

import java.util.List;

public interface BaseMapper<E, D> {

    E toEntity(D d);

    D toDto(E e);

    List<E> toEntities(List<D> dtoList);
    List<D> toDtoList(List<E> entities);

}
