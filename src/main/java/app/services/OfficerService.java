package app.services;

import app.models.Officer;
import app.repositories.AppuserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OfficerService implements UserDetailsService {

    private AppuserRepo repo;

    public OfficerService(AppuserRepo repo) {
        this.repo = repo;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Officer officer = repo.findAllByUsername(username);
        if (username == null) {
            throw new UsernameNotFoundException("User not founded");
        }
        return officer;
    }
}


