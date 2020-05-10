
package pl.egu.agh.soa;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStudentsByFacultyResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStudentsByFacultyResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="students" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="student" type="{http://api.soa.agh.edu.pl/}student" maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStudentsByFacultyResponse", propOrder = {
    "students"
})
public class GetStudentsByFacultyResponse {

    protected GetStudentsByFacultyResponse.Students students;

    /**
     * Gets the value of the students property.
     * 
     * @return
     *     possible object is
     *     {@link GetStudentsByFacultyResponse.Students }
     *     
     */
    public GetStudentsByFacultyResponse.Students getStudents() {
        return students;
    }

    /**
     * Sets the value of the students property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetStudentsByFacultyResponse.Students }
     *     
     */
    public void setStudents(GetStudentsByFacultyResponse.Students value) {
        this.students = value;
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
     *         &lt;element name="student" type="{http://api.soa.agh.edu.pl/}student" maxOccurs="unbounded" minOccurs="0"/&gt;
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
        "student"
    })
    public static class Students {

        protected List<Student> student;

        /**
         * Gets the value of the student property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the student property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getStudent().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Student }
         * 
         * 
         */
        public List<Student> getStudent() {
            if (student == null) {
                student = new ArrayList<Student>();
            }
            return this.student;
        }

    }

}
