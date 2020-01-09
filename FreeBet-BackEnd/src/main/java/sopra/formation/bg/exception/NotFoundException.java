package sopra.formation.bg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
