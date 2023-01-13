package com.renovationhome.fixitright.web;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.renovationhome.fixitright.domain.User;
import com.renovationhome.fixitright.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository userRepo;

	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("/home")
	String getHome(ModelMap model) {
		model.put("user", new User());
		return "home";
	}

	@PostMapping("/home")
	String postUser(User user) {
		User savedUser = userRepo.save(user);
		sendMail(savedUser);
		return "redirect:/home";
	}

	private void sendMail(User user) {
		final String emailToRecipient = user.getEmail();
		final String emailSubject = "Successfully Registered";
		final String emailMessage = user.getDescription();

		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMessageHelper.setTo(emailToRecipient);
				mimeMessageHelper.setText(emailMessage, true);
				mimeMessageHelper.setSubject(emailSubject);
			}
		});

	}
}
