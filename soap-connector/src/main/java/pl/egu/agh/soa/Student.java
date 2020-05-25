
package pl.egu.agh.soa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for student complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="student"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idx" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="avatarFilePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="faculty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="courses" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="course" type="{http://api.soa.agh.edu.pl/}course" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="dormitory" type="{http://api.soa.agh.edu.pl/}dormitory" minOccurs="0"/&gt;
 *         &lt;element name="organizations" type="{http://api.soa.agh.edu.pl/}organization" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="publications" type="{http://api.soa.agh.edu.pl/}publication" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "student", propOrder = {
    "idx",
    "firstName",
    "lastName",
    "avatarFilePath",
    "age",
    "faculty",
    "courses",
    "dormitory",
    "organizations",
    "publications"
})
public class Student {

    protected Integer idx;
    protected String firstName;
    protected String lastName;
    protected String avatarFilePath;
    protected Integer age;
    protected String faculty;
    protected Student.Courses courses;
    protected Dormitory dormitory;
    @XmlElement(nillable = true)
    protected List<Organization> organizations;
    @XmlElement(nillable = true)
    protected List<Publication> publications;

    /**
     * Gets the value of the idx property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdx() {
        return idx;
    }

    /**
     * Sets the value of the idx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdx(Integer value) {
        this.idx = value;
    }

    /**
     * Gets the value of the firstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the value of the firstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstName(String value) {
        this.firstName = value;
    }

    /**
     * Gets the value of the lastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the value of the lastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastName(String value) {
        this.lastName = value;
    }

    /**
     * Gets the value of the avatarFilePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvatarFilePath() {
        return avatarFilePath;
    }

    /**
     * Sets the value of the avatarFilePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvatarFilePath(String value) {
        this.avatarFilePath = value;
    }

    /**
     * Gets the value of the age property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the value of the age property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAge(Integer value) {
        this.age = value;
    }

    /**
     * Gets the value of the faculty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * Sets the value of the faculty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaculty(String value) {
        this.faculty = value;
    }

    /**
     * Gets the value of the courses property.
     * 
     * @return
     *     possible object is
     *     {@link Student.Courses }
     *     
     */
    public Student.Courses getCourses() {
        return courses;
    }

    /**
     * Sets the value of the courses property.
     * 
     * @param value
     *     allowed object is
     *     {@link Student.Courses }
     *     
     */
    public void setCourses(Student.Courses value) {
        this.courses = value;
    }

    /**
     * Gets the value of the dormitory property.
     * 
     * @return
     *     possible object is
     *     {@link Dormitory }
     *     
     */
    public Dormitory getDormitory() {
        return dormitory;
    }

    /**
     * Sets the value of the dormitory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dormitory }
     *     
     */
    public void setDormitory(Dormitory value) {
        this.dormitory = value;
    }

    /**
     * Gets the value of the organizations property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the organizations property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOrganizations().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Organization }
     * 
     * 
     */
    public List<Organization> getOrganizations() {
        if (organizations == null) {
            organizations = new ArrayList<Organization>();
        }
        return this.organizations;
    }

    /**
     * Gets the value of the publications property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the publications property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPublications().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Publication }
     * 
     * 
     */
    public List<Publication> getPublications() {
        if (publications == null) {
            publications = new ArrayList<Publication>();
        }
        return this.publications;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="course" type="{http://api.soa.agh.edu.pl/}course" maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "course"
    })
    public static class Courses {

        protected List<Course> course;

        /**
         * Gets the value of the course property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the course property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCourse().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Course }
         * 
         * 
         */
        public List<Course> getCourse() {
            if (course == null) {
                course = new ArrayList<Course>();
            }
            return this.course;
        }

    }

}
