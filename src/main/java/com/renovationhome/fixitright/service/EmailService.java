package com.renovationhome.fixitright.service;

import com.renovationhome.fixitright.domain.EmailDetail;

public interface EmailService {

	// To send a simple email
	String sendSimpleMail(EmailDetail details);


	// To send an email with attachment
	String sendMailWithAttachment(EmailDetail details);
}
