package fr.lpdaoo.mycities_dominique_nono.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class VilleIntrouvableException extends RuntimeException {
	
	public VilleIntrouvableException(String s) {
		super(s);
	}

}
