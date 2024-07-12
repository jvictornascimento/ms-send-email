package br.com.jvictornascimento.send_email.repositories;

import br.com.jvictornascimento.send_email.models.EmailModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {
}
