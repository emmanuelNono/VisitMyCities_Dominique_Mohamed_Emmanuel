package fr.lpdaoo.VisitMyCitiesBatiment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PhotoIntrouvableException extends Exception {
	public PhotoIntrouvableException(String m) {
		super(m);
	}
}