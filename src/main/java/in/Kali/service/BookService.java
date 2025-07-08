package in.Kali.service;

import java.util.List;

import in.Kali.entity.Books;

public interface BookService {
	
public boolean add(Books b);
	
	public List<Books> getAllBook();
	
	public boolean Delete(Integer id);
	
	public Boolean update(Books b);
	
	public Books getSingleBook(Integer id);

    
	
}
