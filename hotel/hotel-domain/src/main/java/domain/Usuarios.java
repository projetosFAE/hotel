/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsuario", query = "SELECT u FROM Usuarios u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuarios.findByUsuarioNome", query = "SELECT u FROM Usuarios u WHERE u.usuarioNome = :usuarioNome"),
    @NamedQuery(name = "Usuarios.findByUsuarioEmail", query = "SELECT u FROM Usuarios u WHERE u.usuarioEmail = :usuarioEmail"),
    @NamedQuery(name = "Usuarios.findByUsuarioDocumentoTipo", query = "SELECT u FROM Usuarios u WHERE u.usuarioDocumentoTipo = :usuarioDocumentoTipo"),
    @NamedQuery(name = "Usuarios.findByUsuarioDocumento", query = "SELECT u FROM Usuarios u WHERE u.usuarioDocumento = :usuarioDocumento"),
    @NamedQuery(name = "Usuarios.findByUsuarioLogin", query = "SELECT u FROM Usuarios u WHERE u.usuarioLogin = :usuarioLogin"),
    @NamedQuery(name = "Usuarios.findByUsuarioSenha", query = "SELECT u FROM Usuarios u WHERE u.usuarioSenha = :usuarioSenha")})
public class Usuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuario")
    private Integer usuario;
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

    public Usuarios() {
    }

    public Usuarios(Integer usuario) {
        this.usuario = usuario;
    }

    public Usuarios(Integer usuario, String usuarioNome, String usuarioEmail, String usuarioDocumentoTipo, String usuarioDocumento, String usuarioLogin, String usuarioSenha) {
        this.usuario = usuario;
        this.usuarioNome = usuarioNome;
        this.usuarioEmail = usuarioEmail;
        this.usuarioDocumentoTipo = usuarioDocumentoTipo;
        this.usuarioDocumento = usuarioDocumento;
        this.usuarioLogin = usuarioLogin;
        this.usuarioSenha = usuarioSenha;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Usuarios[ usuario=" + usuario + " ]";
    }
    
}
