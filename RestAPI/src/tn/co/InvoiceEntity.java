package tn.co;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "invoice", schema = "loginUserBD", catalog = "")
public class InvoiceEntity {
    private int idInv;
    private String productsInv;
    private Double paidInv;
    private Integer idCustomerInv;
    private Timestamp date;

    @Id
    @Column(name = "idInv")
    public int getIdInv() {
        return idInv;
    }

    public void setIdInv(int idInv) {
        this.idInv = idInv;
    }

    @Basic
    @Column(name = "productsInv")
    public String getProductsInv() {
        return productsInv;
    }

    public void setProductsInv(String productsInv) {
        this.productsInv = productsInv;
    }

    @Basic
    @Column(name = "paidInv")
    public Double getPaidInv() {
        return paidInv;
    }

    public void setPaidInv(Double paidInv) {
        this.paidInv = paidInv;
    }

    @Basic
    @Column(name = "idCustomerInv")
    public Integer getIdCustomerInv() {
        return idCustomerInv;
    }

    public void setIdCustomerInv(Integer idCustomerInv) {
        this.idCustomerInv = idCustomerInv;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceEntity that = (InvoiceEntity) o;
        return idInv == that.idInv &&
                Objects.equals(productsInv, that.productsInv) &&
                Objects.equals(paidInv, that.paidInv) &&
                Objects.equals(idCustomerInv, that.idCustomerInv) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInv, productsInv, paidInv, idCustomerInv, date);
    }


//    @Override
//    public String toString() {
//        String s = String
//                .format(" { \"id\" : %s , \"idCustomer\" : %s , \"products\" : [ %s ] , \"paid\" : %s , \"date\" : \"%s\" }" , idInv , idCustomerInv , productsInv, paidInv, date );
//
//        return  s;
//
//    }
}
