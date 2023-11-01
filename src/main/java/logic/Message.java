package logic;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Message")
@Table(name = "Messages")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMessage")
    private int id;

    @Basic
    @Column(name = "Content", nullable = false, length = 1000)
    private String content;
    @Column(name = "ShippingDate", nullable = false)
    private LocalDateTime shippingDate;
    @ManyToOne
    @JoinColumn(name = "IdSender")
    private User remitente;
    @ManyToOne
    @JoinColumn(name = "IdAddressee")
    private User destinatario;

    public Message() {
    }

    public Message(String content, LocalDateTime shippingDate, User remitente, User destinatario) {
        this.content = content;
        this.shippingDate = shippingDate;
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
    }

    public User getRemitente() {
        return remitente;
    }

    public void setRemitente(User remitente) {
        this.remitente = remitente;
    }

    public User getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(User destinatario) {
        this.destinatario = destinatario;
    }

}
