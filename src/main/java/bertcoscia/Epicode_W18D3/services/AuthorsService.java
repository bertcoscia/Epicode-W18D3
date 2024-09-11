package bertcoscia.Epicode_W18D3.services;

import bertcoscia.Epicode_W18D3.entities.Author;
import bertcoscia.Epicode_W18D3.exceptions.BadRequestException;
import bertcoscia.Epicode_W18D3.repositories.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorsService {
    @Autowired
    private AuthorsRepository authorsRepository;

    public Author save(Author body) {
        if (this.authorsRepository.existsByEmail(body.getEmail())) throw new BadRequestException("Email already used");
        body.setAvatarUrl("https://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getSurname());
        return this.authorsRepository.save(body);
    }

    
}
