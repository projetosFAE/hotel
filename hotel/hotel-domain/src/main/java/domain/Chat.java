/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "chat")
public class Chat implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "chat-sequence")
    @SequenceGenerator(name = "chat-sequence",
    sequenceName = "chat_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "chat_conversa")
    private String chatConversa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chat")
    private List<Usuarioxchat> usuarioxchatList;

    public Chat() {
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
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
}
