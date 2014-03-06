package notes.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
    public class CustomUserDetailsService implements UserDetailsService
    {
        public UserDetails loadUserByUsername(String username)
                throws UsernameNotFoundException, DataAccessException
        {
            System.out.println("username recieved :: " + username);
            @SuppressWarnings("deprecation")
             
            //Get this user details from database and set its roles also here
              
            UserDetails user = new User(username, "password", true, true, true, true,
                    Arrays.asList(new GrantedAuthority[]{ new SimpleGrantedAuthority("ROLE_SCARVAREZ_MEMBER")}));
            return user;
        }
        
       
            
    }

