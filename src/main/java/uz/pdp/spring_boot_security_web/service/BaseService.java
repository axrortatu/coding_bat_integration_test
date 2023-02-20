package uz.pdp.spring_boot_security_web.service;

import java.util.List;

public interface BaseService<T, R> {
    R getList();

    R add(T t);

    R deleteById(Integer id);

    R update(Integer id, T t);

    R getById(Integer id);
}
