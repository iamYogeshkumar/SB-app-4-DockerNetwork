package in.Kali.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Kali.entity.Books;
import in.Kali.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepo repo;

	public boolean add(Books b) {
		Books save = repo.save(b);
		List<Books> all = repo.findAll();
		return save.getId()!=null;
	}

	public List<Books> getAllBook() {
        List<Books> all = repo.findAll();
        
		return all;
	}

	public boolean Delete(Integer id) {
		try {
			repo.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Boolean update(Books b) {
		 try {
			 repo.save(b); 
			 return true;
		 }catch (Exception e) {
			
		}
		return false;
	}

	@Override
	public Books getSingleBook(Integer id) {
		Optional<Books> byId = repo.findById(id);
		Books books = byId.get();
		return books;
	}
}
