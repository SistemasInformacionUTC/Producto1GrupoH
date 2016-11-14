package models;

import java.util.*;
import javax.persistence.*;

import com.avaje.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

@Entity 
public class Memoria extends Model{

	 private static final long serialVersionUID = 1L;

		@Id
	    public Long id;
	    
	    @Constraints.Required
	    public int codigo1;
	    
	    
	    @Constraints.Required
	    public int codigo2;
	    
	    
	    @ManyToOne
	    public Computer computer;
	    
	    
	    
	    /**
	     * Generic query helper for entity Computer with id Long
	     */
	    public static Find<Long,Memoria> find = new Find<Long,Memoria>(){};
	    
	    /**
	     * Return a paged list of computer
	     *
	     * @param page Page to display
	     * @param pageSize Number of computers per page
	     * @param sortBy Computer property used for sorting
	     * @param order Sort order (either or asc or desc)
	     * @param filter Filter applied on the name column
	     */
	    public static PagedList<Memoria> page(int page, int pageSize, String sortBy, String order, String filter) {
	        return
	            find.where()
	                .ilike("codigo1", "%" + filter + "%")
	                .orderBy(sortBy + " " + order)
	                .fetch("computer")
	                .findPagedList(page, pageSize);
	    }
}
