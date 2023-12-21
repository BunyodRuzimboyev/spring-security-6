package uz.br29.appfl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import uz.br29.appfl.entity.Role;
import uz.br29.appfl.entity.User;
import uz.br29.appfl.repository.UserRepository;

@SpringBootApplication
@RequiredArgsConstructor
public class AppFlApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppFlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        User adminAccount = userRepository.findByRole(Role.ADMIN);
        if (null == adminAccount) {
            User admin = new User();

            admin.setEmail("admin@gmail.com");
            admin.setFirstname("admin");
            admin.setPassword(new BCryptPasswordEncoder().encode("123"));
            admin.setRole(Role.ADMIN);

            userRepository.save(admin);
        }
    }
}
