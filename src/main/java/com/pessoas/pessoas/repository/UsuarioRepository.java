package com.pessoas.pessoas.repository;

import com.pessoas.pessoas.controller.UserDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioRepository {

    private static List<UserDTO> usuarios;

    public UsuarioRepository() {
        UserDTO userDTO = new UserDTO();
        userDTO.setNome("Eduardo");
        userDTO.setUsuario("Edu");
        userDTO.setCpf("123");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelefone("1234-3454");
        userDTO.setDataCadastro(new Date());


        UserDTO userDTO2 = new UserDTO();
        userDTO2.setNome("Luiz");
        userDTO2.setUsuario("Lz");
        userDTO2.setCpf("456");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setTelefone("1234-3454");
        userDTO2.setDataCadastro(new Date());


        UserDTO userDTO3 = new UserDTO();
        userDTO3.setNome("Bruna");
        userDTO3.setUsuario("Br");
        userDTO3.setCpf("678");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setTelefone("1234-3454");
        userDTO3.setDataCadastro(new Date());


        usuarios = new ArrayList<>();
        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);

    }

    public static List<UserDTO> findAll(UserDTO userDTO){
        return usuarios;
    }
    public UserDTO findOne(String Cpf){
        return usuarios.stream().filter(e -> e.getCpf() == Cpf).findFirst().get();


    }


}
