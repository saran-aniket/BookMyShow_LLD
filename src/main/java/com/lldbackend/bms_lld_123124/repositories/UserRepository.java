package com.lldbackend.bms_lld_123124.repositories;

import com.lldbackend.bms_lld_123124.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String username);
    Optional<User> findById(Long Id);
    User save(User user);
    User deleteUserByUserName(String username);

    @Override
    <S extends User> List<S> saveAll(Iterable<S> entities);
}
