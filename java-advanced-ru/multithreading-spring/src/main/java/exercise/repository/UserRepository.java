package exercise.repository;

import exercise.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;


// BEGIN
    public interface UserRepository extends ReactiveCrudRepository<User, BigInteger>{
    }
// END
