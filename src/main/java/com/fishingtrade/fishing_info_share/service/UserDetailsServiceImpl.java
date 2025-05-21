package com.fishingtrade.fishing_info_share.service;

import com.fishingtrade.fishing_info_share.entity.User;
import com.fishingtrade.fishing_info_share.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.debug("loadUserByUsername started for email: {}", email);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            logger.debug("User not found with email: {}", email);
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles("USER") // ユーザーの権限を設定 (必要に応じて変更)
                .build();
        logger.debug("loadUserByUsername finished for email: {}", email);
        return userDetails;
    }
}