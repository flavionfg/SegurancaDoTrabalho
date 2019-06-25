package com.seguranca.trabalho.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.seguranca.trabalho.Model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{	

	Usuario findBySenhaAndNomeUsuario(String senha , String nomeUsuario);

	Usuario findUsuarioByCpf(String cpf);
}
