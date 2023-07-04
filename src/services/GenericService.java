package services;

import java.util.List;

public interface GenericService <T>{
    String add(Long  id, T t);

    void removeById(Long id);

    String updateById(Long id, T t);
}
