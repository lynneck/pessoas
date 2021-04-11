package com.pessoas.pessoas.controller;


import com.pessoas.pessoas.repository.UsuarioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UsuarioRepository UsuarioRepository = new UsuarioRepository();
    private UserDTO UserDTO = new UserDTO();

    @GetMapping("/")
    public String getMensagem() {
        return "Spring boot is working!";

    }

    @GetMapping("/users") // listar todos os usuarios cadrastrados
    public List<UserDTO> listarUsuarios() {
        return UsuarioRepository.findAll(UserDTO);
    }

    @GetMapping("/users/{cpf}") //Filtra um usuario pela URL colocando o numero do cpf
    public UserDTO getUsersFiltro(@PathVariable String cpf) {
        for (UserDTO userFilter : listarUsuarios()) {
            if (userFilter.getCpf().equals(cpf))
                return userFilter;
        }

        return null;
    }

    @PostMapping("newUser")
// inserir um novo usuario
    UserDTO inserir(@RequestBody UserDTO userDTO) {
        userDTO.setDataCadastro(new Date());
        listarUsuarios().add(userDTO);
        return userDTO;
    }

    @DeleteMapping("users/{cpf}")// exclui um usuario pela URL colocando o numero do cpf
    public boolean remover(@PathVariable String cpf) {
        for (UserDTO userFilter : listarUsuarios()) {
            if (userFilter.getCpf().equals(cpf)) {
                listarUsuarios().remove(userFilter);
                return true;


            }
        }
        return false;
    }

    /*@PutMapping("users/{cpf} ")
    public UserDTO UpdateUserDTO(@PathVariable (value = "cpf") String cpf, @RequestBody UserDTO userDTO){
     UserDTO listaUsuarios = UsuarioRepository.findOne(cpf);
                return userDTO;
    }*/

    @RequestMapping(value = "/users/{cpf}", method = RequestMethod.PUT)
    public UserDTO Put(@PathVariable(value = "cpf") long id, @RequestBody UserDTO userDTO) {
        Optional<UserDTO> oldPessoa = UsuarioRepository.findAll (UserDTO);
            if (oldPessoa.isPresent()) {
                UserDTO pessoa = oldPessoa.get();
                UserDTO.setCpf("cpf");
                UsuarioRepository.equals(listarUsuarios());
                return UserDTO;
            } else
                return UserDTO;


    }
}