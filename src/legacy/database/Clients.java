package legacy.database;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "clients", catalog = "legacy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
    @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id"),
    @NamedQuery(name = "Clients.findByName", query = "SELECT c FROM Clients c WHERE c.name = :name"),
    @NamedQuery(name = "Clients.findByAddress", query = "SELECT c FROM Clients c WHERE c.address = :address"),
    @NamedQuery(name = "Clients.findByCity", query = "SELECT c FROM Clients c WHERE c.city = :city"),
    @NamedQuery(name = "Clients.findByProvince", query = "SELECT c FROM Clients c WHERE c.province = :province"),
    @NamedQuery(name = "Clients.findByPostal", query = "SELECT c FROM Clients c WHERE c.postal = :postal"),
    @NamedQuery(name = "Clients.findByCountry", query = "SELECT c FROM Clients c WHERE c.country = :country"),
    @NamedQuery(name = "Clients.findByPhone1", query = "SELECT c FROM Clients c WHERE c.phone1 = :phone1"),
    @NamedQuery(name = "Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email = :email"),
    @NamedQuery(name = "Clients.findByDateCreated", query = "SELECT c FROM Clients c WHERE c.dateCreated = :dateCreated"),
    @NamedQuery(name = "Clients.findByDateUpdated", query = "SELECT c FROM Clients c WHERE c.dateUpdated = :dateUpdated"),
    @NamedQuery(name = "Clients.findByDateCancelled", query = "SELECT c FROM Clients c WHERE c.dateCancelled = :dateCancelled"),
    @NamedQuery(name = "Clients.findByDateSold", query = "SELECT c FROM Clients c WHERE c.dateSold = :dateSold"),
    @NamedQuery(name = "Clients.findByRegFee", query = "SELECT c FROM Clients c WHERE c.regFee = :regFee"),
    @NamedQuery(name = "Clients.findByTaxRate", query = "SELECT c FROM Clients c WHERE c.taxRate = :taxRate"),
    @NamedQuery(name = "Clients.findByRefunded", query = "SELECT c FROM Clients c WHERE c.refunded = :refunded"),
    @NamedQuery(name = "Clients.findByOpener", query = "SELECT c FROM Clients c WHERE c.opener = :opener"),
    @NamedQuery(name = "Clients.findByCloser1", query = "SELECT c FROM Clients c WHERE c.closer1 = :closer1"),
    @NamedQuery(name = "Clients.findByYear", query = "SELECT c FROM Clients c WHERE c.year = :year"),
    @NamedQuery(name = "Clients.findByMake", query = "SELECT c FROM Clients c WHERE c.make = :make"),
    @NamedQuery(name = "Clients.findByModel", query = "SELECT c FROM Clients c WHERE c.model = :model"),
    @NamedQuery(name = "Clients.findByPrice", query = "SELECT c FROM Clients c WHERE c.price = :price"),
    @NamedQuery(name = "Clients.findByTrim", query = "SELECT c FROM Clients c WHERE c.trim = :trim"),
    @NamedQuery(name = "Clients.findByKilometres", query = "SELECT c FROM Clients c WHERE c.kilometres = :kilometres"),
    @NamedQuery(name = "Clients.findByExteriorColor", query = "SELECT c FROM Clients c WHERE c.exteriorColor = :exteriorColor"),
    @NamedQuery(name = "Clients.findByInteriorColor", query = "SELECT c FROM Clients c WHERE c.interiorColor = :interiorColor"),
    @NamedQuery(name = "Clients.findByInteriorType", query = "SELECT c FROM Clients c WHERE c.interiorType = :interiorType"),
    @NamedQuery(name = "Clients.findByDescription", query = "SELECT c FROM Clients c WHERE c.description = :description"),
    @NamedQuery(name = "Clients.findByFeatures", query = "SELECT c FROM Clients c WHERE c.features = :features"),
    @NamedQuery(name = "Clients.findByStatus", query = "SELECT c FROM Clients c WHERE c.status = :status"),
    @NamedQuery(name = "Clients.findByCompany", query = "SELECT c FROM Clients c WHERE c.company = :company"),
    @NamedQuery(name = "Clients.findByCloser2", query = "SELECT c FROM Clients c WHERE c.closer2 = :closer2"),
    @NamedQuery(name = "Clients.findByPhone2", query = "SELECT c FROM Clients c WHERE c.phone2 = :phone2"),
    @NamedQuery(name = "Clients.findByMileageType", query = "SELECT c FROM Clients c WHERE c.mileageType = :mileageType"),
    @NamedQuery(name = "Clients.findByConfirmation", query = "SELECT c FROM Clients c WHERE c.confirmation = :confirmation"),
    @NamedQuery(name = "Clients.findByPaymentMethod", query = "SELECT c FROM Clients c WHERE c.paymentMethod = :paymentMethod"),
    @NamedQuery(name = "Clients.findByRecording", query = "SELECT c FROM Clients c WHERE c.recording = :recording"),
    @NamedQuery(name = "Clients.findByVerifier", query = "SELECT c FROM Clients c WHERE c.verifier = :verifier"),
    @NamedQuery(name = "Clients.findByNotes", query = "SELECT c FROM Clients c WHERE c.notes = :notes")})
public class Clients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "province")
    private String province;
    @Column(name = "postal")
    private String postal;
    @Column(name = "country")
    private String country;
    @Column(name = "phone1")
    private String phone1;
    @Column(name = "email")
    private String email;
    @Column(name = "date_created")
    private String dateCreated;
    @Column(name = "date_updated")
    private String dateUpdated;
    @Column(name = "date_cancelled")
    private String dateCancelled;
    @Column(name = "date_sold")
    private String dateSold;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "reg_fee")
    private BigDecimal regFee;
    @Column(name = "tax_rate")
    private Integer taxRate;
    @Column(name = "refunded")
    private BigDecimal refunded;
    @Column(name = "opener")
    private String opener;
    @Column(name = "closer1")
    private String closer1;
    @Column(name = "year")
    private Integer year;
    @Column(name = "make")
    private String make;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "trim")
    private String trim;
    @Column(name = "kilometres")
    private Integer kilometres;
    @Column(name = "exterior_color")
    private String exteriorColor;
    @Column(name = "interior_color")
    private String interiorColor;
    @Column(name = "interior_type")
    private String interiorType;
    @Column(name = "description")
    private String description;
    @Column(name = "features")
    private String features;
    @Column(name = "status")
    private String status;
    @Column(name = "company")
    private String company;
    @Column(name = "closer2")
    private String closer2;
    @Column(name = "phone2")
    private String phone2;
    @Column(name = "mileageType")
    private String mileageType;
    @Column(name = "confirmation")
    private String confirmation;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "recording")
    private String recording;
    @Column(name = "verifier")
    private String verifier;
    @Column(name = "notes")
    private String notes;

    public Clients() {
    }

    public Clients(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getDateCancelled() {
        return dateCancelled;
    }

    public void setDateCancelled(String dateCancelled) {
        this.dateCancelled = dateCancelled;
    }

    public String getDateSold() {
        return dateSold;
    }

    public void setDateSold(String dateSold) {
        this.dateSold = dateSold;
    }

    public BigDecimal getRegFee() {
        return regFee;
    }

    public void setRegFee(BigDecimal regFee) {
        this.regFee = regFee;
    }

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getRefunded() {
        return refunded;
    }

    public void setRefunded(BigDecimal refunded) {
        this.refunded = refunded;
    }

    public String getOpener() {
        return opener;
    }

    public void setOpener(String opener) {
        this.opener = opener;
    }

    public String getCloser1() {
        return closer1;
    }

    public void setCloser1(String closer1) {
        this.closer1 = closer1;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public Integer getKilometres() {
        return kilometres;
    }

    public void setKilometres(Integer kilometres) {
        this.kilometres = kilometres;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getInteriorType() {
        return interiorType;
    }

    public void setInteriorType(String interiorType) {
        this.interiorType = interiorType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCloser2() {
        return closer2;
    }

    public void setCloser2(String closer2) {
        this.closer2 = closer2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getMileageType() {
        return mileageType;
    }

    public void setMileageType(String mileageType) {
        this.mileageType = mileageType;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getRecording() {
        return recording;
    }

    public void setRecording(String recording) {
        this.recording = recording;
    }

    public String getVerifier() {
        return verifier;
    }

    public void setVerifier(String verifier) {
        this.verifier = verifier;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return Clients.class.getSimpleName()
                + "\n" + id
                + "\n" + name
                + "\n" + phone1
                + "\n" + model
                + "\n" + notes
                + "\n" + description
                + "\n" + features
                + "\n";
    }
}
