/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author AlexPorto
 */
@Entity
@Table(name = "usuarios")
public class Usuarios implements Persistent, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "usuarios-sequence")
    @SequenceGenerator(name = "usuarios-sequence",
    sequenceName = "usuarios_seq")
    private Long id;
    @Basic(optional = false)
    @Column(name = "usuario_nome")
    private String usuarioNome;
    @Basic(optional = false)
    @Column(name = "usuario_email")
    private String usuarioEmail;
    @Basic(optional = false)
    @Column(name = "usuario_documento_tipo")
    private String usuarioDocumentoTipo;
    @Basic(optional = false)
    @Column(name = "usuario_documento")
    private String usuarioDocumento;
    @Basic(optional = false)
    @Column(name = "usuario_login")
    private String usuarioLogin;
    @Basic(optional = false)
    @Column(name = "usuario_senha")
    private String usuarioSenha;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<Usuarioxchat> usuarioxchatList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<Logradouroxusuario> logradouroxusuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<Reservas> reservasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarios")
    private List<Telefones> telefonesList;
    @JoinColumn(name = "nivel", referencedColumnName = "nivel")
    @ManyToOne(optional = false)
    private Niveis niveis;
    @Column(name = "usuario_data_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date usuarioDataRegistro;

    public Usuarios() {
    }

    public Usuarios(Integer usuario, String usuarioNome, String usuarioEmail, String usuarioDocumentoTipo, String usuarioDocumento, String usuarioLogin, String usuarioSenha) {
        this.usuarioNome = usuarioNome;
        this.usuarioEmail = usuarioEmail;
        this.usuarioDocumentoTipo = usuarioDocumentoTipo;
        this.usuarioDocumento = usuarioDocumento;
        this.usuarioLogin = usuarioLogin;
        this.usuarioSenha = usuarioSenha;
    }

    @Override
    public void setId(Serializable id) {
        this.id = (Long) id;
    }

    @Override
    public Long getId() {
       return this.id;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioDocumentoTipo() {
        return usuarioDocumentoTipo;
    }

    public void setUsuarioDocumentoTipo(String usuarioDocumentoTipo) {
        this.usuarioDocumentoTipo = usuarioDocumentoTipo;
    }

    public String getUsuarioDocumento() {
        return usuarioDocumento;
    }

    public void setUsuarioDocumento(String usuarioDocumento) {
        this.usuarioDocumento = usuarioDocumento;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }

    @XmlTransient
    public List<Usuarioxchat> getUsuarioxchatList() {
        return usuarioxchatList;
    }

    public void setUsuarioxchatList(List<Usuarioxchat> usuarioxchatList) {
        this.usuarioxchatList = usuarioxchatList;
    }

    @XmlTransient
    public List<Logradouroxusuario> getLogradouroxusuarioList() {
        return logradouroxusuarioList;
    }

    public void setLogradouroxusuarioList(List<Logradouroxusuario> logradouroxusuarioList) {
        this.logradouroxusuarioList = logradouroxusuarioList;
    }

    @XmlTransient
    public List<Reservas> getReservasList() {
        return reservasList;
    }

    public void setReservasList(List<Reservas> reservasList) {
        this.reservasList = reservasList;
    }

    @XmlTransient
    public List<Telefones> getTelefonesList() {
        return telefonesList;
    }

    public void setTelefonesList(List<Telefones> telefonesList) {
        this.telefonesList = telefonesList;
    }

    public Niveis getNiveis() {
        return niveis;
    }

    public void setNiveis(Niveis niveis) {
        this.niveis = niveis;
    }

    public Date getUsuarioDataRegistro() {
        return usuarioDataRegistro;
    }

    public void setUsuarioDataRegistro(Date usuarioDataRegistro) {
        this.usuarioDataRegistro = usuarioDataRegistro;
    }    
}
