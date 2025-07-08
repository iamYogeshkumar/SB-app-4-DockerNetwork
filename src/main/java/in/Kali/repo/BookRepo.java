package in.Kali.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.Kali.entity.Books;

public interface BookRepo extends JpaRepository<Books, Integer> {
	
	

}
