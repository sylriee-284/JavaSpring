package vn.hoidanit.laptopshop.repository;

import java.util.List;

import org.hibernate.sql.Delete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.hoidanit.laptopshop.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User syl1);

    List<User> findByEmail(String email);

    User findById(long id);

    Delete deleteById(long id);
}
