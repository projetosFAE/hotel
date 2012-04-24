/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmd.hotel.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "usuarioxchat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarioxchat.findAll", query = "SELECT u FROM Usuarioxchat u"),
    @NamedQuery(name = "Usuarioxchat.findByUsuarioXchat", query = "SELECT u FROM Usuarioxchat u WHERE u.usuarioXchat = :usuarioXchat")})
public class Usuarioxchat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuarioXchat")
    private Integer usuarioXchat;
    @JoinColumn(name = "chat", referencedColumnName = "chat")
    @ManyToOne(optional = false)
    private Chat chat;
    @JoinColumn(name = "usuario", referencedColumnName = "usuario")
    @ManyToOne(optional = false)
    private Usuarios usuario;

    public Usuarioxchat() {
    }

    public Usuarioxchat(Integer usuarioXchat) {
        this.usuarioXchat = usuarioXchat;
    }

    public Integer getUsuarioXchat() {
        return usuarioXchat;
    }

    public void setUsuarioXchat(Integer usuarioXchat) {
        this.usuarioXchat = usuarioXchat;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioXchat != null ? usuarioXchat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarioxchat)) {
            return false;
        }
        Usuarioxchat other = (Usuarioxchat) object;
        if ((this.usuarioXchat == null && other.usuarioXchat != null) || (this.usuarioXchat != null && !this.usuarioXchat.equals(other.usuarioXchat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Usuarioxchat[ usuarioXchat=" + usuarioXchat + " ]";
    }
    
}
