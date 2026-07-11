package com.github.gtbdemian.budgetapprovalsystem.mapper;

import com.github.gtbdemian.budgetapprovalsystem.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
    User findById(Long id);
    User findByEmail(String email);
    void insert(User user);
    void update(User user);
    void delete(Long id);
}
