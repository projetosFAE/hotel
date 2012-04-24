/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmd.hotel.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "chat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chat.findAll", query = "SELECT c FROM Chat c"),
    @NamedQuery(name = "Chat.findByChat", query = "SELECT c FROM Chat c WHERE c.chat = :chat"),
    @NamedQuery(name = "Chat.findByChatConversa", query = "SELECT c FROM Chat c WHERE c.chatConversa = :chatConversa")})
public class Chat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "chat")
    private Integer chat;
    @Basic(optional = false)
    @Column(name = "chat_conversa")
    private String chatConversa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chat")
    private List<Usuarioxchat> usuarioxchatList;

    public Chat() {
    }

    public Chat(Integer chat) {
        this.chat = chat;
    }

    public Chat(Integer chat, String chatConversa) {
        this.chat = chat;
        this.chatConversa = chatConversa;
    }

    public Integer getChat() {
        return chat;
    }

    public void setChat(Integer chat) {
        this.chat = chat;
    }

    public String getChatConversa() {
        return chatConversa;
    }

    public void setChatConversa(String chatConversa) {
        this.chatConversa = chatConversa;
    }

    @XmlTransient
    public List<Usuarioxchat> getUsuarioxchatList() {
        return usuarioxchatList;
    }

    public void setUsuarioxchatList(List<Usuarioxchat> usuarioxchatList) {
        this.usuarioxchatList = usuarioxchatList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chat != null ? chat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.chat == null && other.chat != null) || (this.chat != null && !this.chat.equals(other.chat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cmd.hoteldomain.domain.Chat[ chat=" + chat + " ]";
    }
    
}
