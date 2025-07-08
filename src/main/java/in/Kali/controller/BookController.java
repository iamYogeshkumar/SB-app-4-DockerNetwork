package in.Kali.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.Kali.entity.Books;
import in.Kali.service.BookServiceImpl;

@Controller
public class BookController {
	@Autowired
	BookServiceImpl bookImpl;
	
	@GetMapping("/")
	public String getBooks(Model m) {
	    List<Books> allBook = bookImpl.getAllBook();
	    System.out.println("Books: " + allBook); // debug line
	    m.addAttribute("allBook", allBook);
	    return "index";
	}


	
     @PostMapping("/add")
	public String add(@ModelAttribute  Books b, Model m) {
		boolean c = bookImpl.add(b);
		String tf=(c==true)?"added":"not added";
		m.addAttribute("tf",tf);
		 m.addAttribute("b", new Books()); // <- Add this line!
		return "addform";
	}
	
     @GetMapping("/form")
	public String addForm(Model m) {
		m.addAttribute("b",new Books());
		return "addform";
	}
     
     @GetMapping("/delete")
     public String deleteBook(@RequestParam("id") int id) {
         bookImpl.Delete(id);
         return "redirect:/"; // or wherever you want to go after delete
     }
     
     @GetMapping("/update")
     public String update(@RequestParam("id") int id,Model m) {
    	 Books book = bookImpl.getSingleBook(id);
    	 m.addAttribute("b", book);
    	 return "addform";
     }

	

}
