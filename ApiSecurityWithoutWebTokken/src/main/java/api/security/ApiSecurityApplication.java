package api.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import api.security.entities.NationalityEntity;
import api.security.entities.PermissionEntity;
import api.security.entities.RoleEntity;
import api.security.entities.UserEntity;
import api.security.entities.enums.PermissionEnum;
import api.security.entities.enums.RoleEnum;
import api.security.services.NationalityServiceImp;
import api.security.services.PermissionServiceImp;
import api.security.services.RoleServiceImp;
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

	@Autowired
	RoleServiceImp roleServiceImp;

	
	@Autowired
	PermissionServiceImp permissionServiceImp;
	
	@Bean
	CommandLineRunner init() {
		return args -> {

			HashSet<NationalityEntity> nationalities = (HashSet<NationalityEntity>) nationalityServiceImp.readAll()
					.stream().collect(Collectors.toSet());
			
			ArrayList<PermissionEntity> permissions = (ArrayList<PermissionEntity>) permissionServiceImp.readAll()
					.stream().collect(Collectors.toList());
			
			ArrayList<RoleEntity> roles = (ArrayList<RoleEntity>) roleServiceImp.readAll()
					.stream().collect(Collectors.toList());
			
			ArrayList<UserEntity> users = (ArrayList<UserEntity>) userServiceImp.readAll()
					.stream().collect(Collectors.toList());
			
			if (nationalities.isEmpty()) {

				nationalities = new HashSet<NationalityEntity>();
				nationalities.add(new NationalityEntity("chile", "español"));
				nationalities.add(new NationalityEntity("peru", "español"));
				nationalities.add(new NationalityEntity("ee.uu", "ingles"));
				nationalities.add(new NationalityEntity("francia", "frances"));
				nationalities.add(new NationalityEntity("brasil", "portugues"));
				
				nationalities.stream().forEach(n -> nationalityServiceImp.create(n));
			}
			
			if (permissions.isEmpty()) {

				permissions = new ArrayList<PermissionEntity>();

				permissions.add(new PermissionEntity(PermissionEnum.CREATE)); 
				permissions.add(new PermissionEntity(PermissionEnum.DELETE));
				permissions.add(new PermissionEntity(PermissionEnum.READ));
				permissions.add(new PermissionEntity(PermissionEnum.UPDATE));
				
				permissions.stream().forEach(p -> permissionServiceImp.create(p));
			}
			
			if (roles.isEmpty()) {

				roles = new ArrayList<RoleEntity>(); 
				roles.add(new RoleEntity(RoleEnum.ADMIN));
				roles.add(new RoleEntity(RoleEnum.DEVELOPER));
				roles.add(new RoleEntity(RoleEnum.INVITED)); 
				roles.add(new RoleEntity(RoleEnum.USER));

				roles.stream().forEach(r -> roleServiceImp.create(r));
				
				for(RoleEntity re : roles)
					roleServiceImp.create(re);
			}

			if (users.isEmpty()) {

				ArrayList<PermissionEntity> adminPermission = new ArrayList<PermissionEntity>();
				adminPermission.add(new PermissionEntity(PermissionEnum.CREATE));
				adminPermission.add(new PermissionEntity(PermissionEnum.READ));
				adminPermission.add(new PermissionEntity(PermissionEnum.UPDATE));

				ArrayList<PermissionEntity> developerPermission = new ArrayList<PermissionEntity>();
				developerPermission.add(new PermissionEntity(PermissionEnum.CREATE));
				developerPermission.add(new PermissionEntity(PermissionEnum.READ));
				developerPermission.add(new PermissionEntity(PermissionEnum.UPDATE));
				developerPermission.add(new PermissionEntity(PermissionEnum.DELETE));

				ArrayList<PermissionEntity> userPermission = new ArrayList<PermissionEntity>();
				developerPermission.add(new PermissionEntity(PermissionEnum.UPDATE));
				userPermission.add(new PermissionEntity(PermissionEnum.READ));

				ArrayList<PermissionEntity> invitedPermission = new ArrayList<PermissionEntity>();
				invitedPermission.add(new PermissionEntity(PermissionEnum.READ));

				// public RoleEntity(RoleEnum roleEnum, Set<PermissionEntity> permissionList)

				List<RoleEntity> roleAdmin = new ArrayList<RoleEntity>();
				roleAdmin.add(new RoleEntity(RoleEnum.ADMIN, adminPermission));

				List<RoleEntity> roleDeveloper = new ArrayList<RoleEntity>();
				roleDeveloper.add(new RoleEntity(RoleEnum.DEVELOPER, developerPermission));

				List<RoleEntity> roleUser = new ArrayList<RoleEntity>();
				roleUser.add(new RoleEntity(RoleEnum.USER, userPermission));

				List<RoleEntity> roleInvited = new ArrayList<RoleEntity>();
				roleInvited.add(new RoleEntity(RoleEnum.USER, invitedPermission));

				UserEntity user = new UserEntity("oscar", passwordEncoder.encode("1234"), true, true, true, true,
						roleAdmin);
				UserEntity user2 = new UserEntity("juan", passwordEncoder.encode("1234"), true, true, true, true,
						roleDeveloper);
				UserEntity user3 = new UserEntity("luis", passwordEncoder.encode("1234"), true, true, true, true,
						roleUser);
				userServiceImp.create(user);
				userServiceImp.create(user2);
				userServiceImp.create(user3);
			}
		};
	} 
}
