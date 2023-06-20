package org.jsp.springbootuserapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.springbootuserapp.dto.User;
import org.jsp.springbootuserapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public class UserDao {
	@Autowired
	private UserRepository repository;

	public User saveUser(User user) {
		return repository.save(user);
	}

	public User updateUser(User user) {
		return repository.save(user);
	}

	public Optional<User> findUser(int id) {
		return repository.findById(id);
	}

	public List<User> findAllUser() {
		return repository.findAll();
	}

	public void deleteUser(int id) {
		repository.deleteById(id);
	}

	public Optional<User> verifyUser(long phone, String password) {
		return repository.verifyUser(phone, password);
	}

	public Optional<User> verifyUser(String email, String password) {
		return repository.verifyUser(email, password);
	}
}
