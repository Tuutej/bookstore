package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepo;

    @Test
    public void findByUsernameRetrieveUser() {
        
        String usernameToSearch = "user";

        User user = userRepo.findByUsername(usernameToSearch);

        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(usernameToSearch);
    }
}