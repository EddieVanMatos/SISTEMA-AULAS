package service;

import com.sistema_aulas.projeto.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UsuarioRepository userRepository;

    @Autowired
    public UserService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Método para listar todos os usuários
    public List<Usuario> getAllUsers() {
        return userRepository.findAll();
    }

    // Método para buscar um usuário pelo ID
    public Optional<Usuario> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Método para adicionar um novo usuário
    public Usuario addUser(Usuario user) {
        return userRepository.save(user);
    }

    // Método para atualizar um usuário
    public Usuario updateUser(Long id, Usuario userDetails) {
        Optional<Usuario> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            Usuario existingUser = optionalUser.get();
            existingUser.setNome(userDetails.getNome());
            existingUser.setEmail(userDetails.getEmail());
            // Atualizar outros campos conforme necessário

            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
    }

    // Método para deletar um usuário pelo ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
