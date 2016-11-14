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
	    public int cod1;
	    
	    
	    @Constraints.Required
	    public int cod2;
	    
	    
	    @ManyToOne
	    public Computer computer;
	    
	    
	    public static Find<Long,Memoria> find = new Find<Long,Memoria>(){};
	    
	   
	    public static PagedList<Memoria> page(int page, int pageSize, String sortBy, String order, String filter) {
	        return
	            find.where()
	                .ilike("cod1", "%" + filter + "%")
	                .orderBy(sortBy + " " + order)
	                .fetch("computer")
	                .findPagedList(page, pageSize);
	    }
}
