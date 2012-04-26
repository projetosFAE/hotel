/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "usuarioxchat")
public class Usuarioxchat implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "usuarioxchat-sequence")
    @SequenceGenerator(name = "usuarioxchat-sequence",
    sequenceName = "usuarioxchat_seq")
    private Long id;
    @JoinColumn(name = "chat", referencedColumnName = "chat")
    @ManyToOne(optional = false)
    private Chat chat;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public Usuarioxchat() {
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
}
