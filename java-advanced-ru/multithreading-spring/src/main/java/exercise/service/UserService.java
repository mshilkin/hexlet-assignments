package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> findById(BigInteger id) {
        return userRepository.findById(id);
    }
    public Mono<User> createUser(User user) {
        return userRepository.save(user);
    }

    public Mono<User> updateUser(BigInteger id, User userDetails) {
        return userRepository.findById(id)
                .flatMap(user -> {
                    user.setFirstName(userDetails.getFirstName()/*"Test"*/);
                    user.setLastName(userDetails.getLastName()/*"User"*/);
                    //user.setEmail(userDetails.getEmail());
                    return userRepository.save(user);
                })
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found")));
    }

    public Mono<Void> deleteUser(BigInteger id) {
        return userRepository.deleteById(id);
    }
    // END
}
