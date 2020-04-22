package fr.lpdaoo.mycities_dominique_nono.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VisiteurIntrouvableException extends RuntimeException {
	
	public VisiteurIntrouvableException(String s) {
		super(s);
	}

}
