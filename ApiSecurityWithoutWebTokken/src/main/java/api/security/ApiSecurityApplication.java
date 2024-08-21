package api.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import api.security.entities.NationalityEntity;
import api.security.entities.PermissionEntity;
import api.security.entities.RoleEntity;
import api.security.entities.RoleEnum;
import api.security.entities.UserEntity;
import api.security.services.NationalityServiceImp;
import api.security.services.UserServiceImp;

@SpringBootApplication
public class ApiSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiSecurityApplication.class, args);
	}

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserServiceImp userServiceImp;

	@Autowired
	NationalityServiceImp nationalityServiceImp;

	@Bean
	CommandLineRunner init() {
		return args -> {

			Set<NationalityEntity> nationalities = new HashSet<NationalityEntity>();
			nationalities.add(new NationalityEntity("chile", "español"));
			nationalities.add(new NationalityEntity("peru", "español"));
			nationalities.add(new NationalityEntity("ee.uu", "ingles"));
			nationalities.add(new NationalityEntity("francia", "frances"));
			nationalities.add(new NationalityEntity("brasil", "portugues"));
			nationalities.stream().forEach((n) -> nationalityServiceImp.create(n));

			Set<PermissionEntity> permissions1 = new HashSet<PermissionEntity>();
			permissions1.add(new PermissionEntity("CREATE"));
			permissions1.add(new PermissionEntity("WRITE"));
			permissions1.add(new PermissionEntity("READ"));
			permissions1.add(new PermissionEntity("DELETE"));

			Set<PermissionEntity> permissions2 = new HashSet<PermissionEntity>();
			permissions2.add(new PermissionEntity("READ"));

			Set<RoleEntity> autorities1 = new HashSet<RoleEntity>();
			autorities1.add(new RoleEntity(RoleEnum.ADMIN, permissions1));
			autorities1.add(new RoleEntity(RoleEnum.USER, permissions1));

			Set<RoleEntity> autorities2 = new HashSet<RoleEntity>();
			autorities2.add(new RoleEntity(RoleEnum.USER, permissions2));

			UserEntity user = new UserEntity("oscar", passwordEncoder.encode("1234"), true, true, true, true,
					autorities1);
			UserEntity user2 = new UserEntity("juan", passwordEncoder.encode("1234"), true, true, true, true,
					autorities2);

			userServiceImp.create(user);
			userServiceImp.create(user2);
		};
	}
}
