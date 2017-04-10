package com.sergio.pragendaclientes.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "clientes")
@XmlRootElement
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    @Column(name = "contacto_frio")
    private Boolean contactoFrio;
    private Boolean referencia;
    @Column(name = "recibio_cmcp")
    private Boolean recibioCmcp;
    @Column(name = "fue_anfitriona")
    private Boolean fueAnfitriona;
    @Column(name = "sesion_color")
    private Boolean sesionColor;
    @Column(name = "sesion_fragancias")
    private Boolean sesionFragancias;
    @Column(name = "comparti_oportunidad")
    private Boolean compartiOportunidad;
    @Column(name = "asistio_evento")
    private Boolean asistioEvento;
    private String personalidad;
    @Lob
    private String observaciones;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pedido> pedidoList;

    public Cliente() {
        // Empty constructor
    }

    public Cliente(Integer id) {
        this.id = id;
    }

    public Cliente(Integer id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getContactoFrio() {
        return contactoFrio;
    }

    public void setContactoFrio(Boolean contactoFrio) {
        this.contactoFrio = contactoFrio;
    }

    public Boolean getReferencia() {
        return referencia;
    }

    public void setReferencia(Boolean referencia) {
        this.referencia = referencia;
    }

    public Boolean getRecibioCmcp() {
        return recibioCmcp;
    }

    public void setRecibioCmcp(Boolean recibioCmcp) {
        this.recibioCmcp = recibioCmcp;
    }

    public Boolean getFueAnfitriona() {
        return fueAnfitriona;
    }

    public void setFueAnfitriona(Boolean fueAnfitriona) {
        this.fueAnfitriona = fueAnfitriona;
    }

    public Boolean getSesionColor() {
        return sesionColor;
    }

    public void setSesionColor(Boolean sesionColor) {
        this.sesionColor = sesionColor;
    }

    public Boolean getSesionFragancias() {
        return sesionFragancias;
    }

    public void setSesionFragancias(Boolean sesionFragancias) {
        this.sesionFragancias = sesionFragancias;
    }

    public Boolean getCompartiOportunidad() {
        return compartiOportunidad;
    }

    public void setCompartiOportunidad(Boolean compartiOportunidad) {
        this.compartiOportunidad = compartiOportunidad;
    }

    public Boolean getAsistioEvento() {
        return asistioEvento;
    }

    public void setAsistioEvento(Boolean asistioEvento) {
        this.asistioEvento = asistioEvento;
    }

    public String getPersonalidad() {
        return personalidad;
    }

    public void setPersonalidad(String personalidad) {
        this.personalidad = personalidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }
    
    public void addPedido(Pedido pedido) {
        pedidoList.add(pedido);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Cliente[ id=" + id + ", nombre=" + nombre + 
                ", telefono= " + telefono + ", direccion=" + direccion +
                ", email=" + email + " ]";
    }
    
}
