package tn.co;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "loginUserBD", catalog = "")
public class ProductEntity {
    private int idPro;
    private String descriptionPro;
    private Integer pricePro;
    private String photo;
    private Integer quantity;

    @Id
    @Column(name = "idPro")
    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    @Basic
    @Column(name = "descriptionPro")
    public String getDescriptionPro() {
        return descriptionPro;
    }

    public void setDescriptionPro(String descriptionPro) {
        this.descriptionPro = descriptionPro;
    }

    @Basic
    @Column(name = "pricePro")
    public Integer getPricePro() {
        return pricePro;
    }

    public void setPricePro(Integer pricePro) {
        this.pricePro = pricePro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return idPro == that.idPro &&
                Objects.equals(descriptionPro, that.descriptionPro) &&
                Objects.equals(pricePro, that.pricePro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPro, descriptionPro, pricePro);
    }

    @Basic
    @Column(name = "photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Basic
    @Column(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
