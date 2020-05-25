
package pl.egu.agh.soa;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.egu.agh.soa package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddStudent_QNAME = new QName("http://api.soa.agh.edu.pl/", "addStudent");
    private final static QName _AddStudentResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "addStudentResponse");
    private final static QName _DeleteStudent_QNAME = new QName("http://api.soa.agh.edu.pl/", "deleteStudent");
    private final static QName _DeleteStudentResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "deleteStudentResponse");
    private final static QName _GetAllStudents_QNAME = new QName("http://api.soa.agh.edu.pl/", "getAllStudents");
    private final static QName _GetAllStudentsResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getAllStudentsResponse");
    private final static QName _GetBase64Avatar_QNAME = new QName("http://api.soa.agh.edu.pl/", "getBase64Avatar");
    private final static QName _GetBase64AvatarResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getBase64AvatarResponse");
    private final static QName _GetStudentByIdx_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentByIdx");
    private final static QName _GetStudentByIdxResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentByIdxResponse");
    private final static QName _GetStudentsByAge_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByAge");
    private final static QName _GetStudentsByAgeResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByAgeResponse");
    private final static QName _GetStudentsByFaculty_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByFaculty");
    private final static QName _GetStudentsByFacultyResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByFacultyResponse");
    private final static QName _GetStudentsByFirstName_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByFirstName");
    private final static QName _GetStudentsByFirstNameResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByFirstNameResponse");
    private final static QName _GetStudentsByLastName_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByLastName");
    private final static QName _GetStudentsByLastNameResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsByLastNameResponse");
    private final static QName _GetStudentsCourses_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsCourses");
    private final static QName _GetStudentsCoursesResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "getStudentsCoursesResponse");
    private final static QName _UpdateStudent_QNAME = new QName("http://api.soa.agh.edu.pl/", "updateStudent");
    private final static QName _UpdateStudentResponse_QNAME = new QName("http://api.soa.agh.edu.pl/", "updateStudentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.egu.agh.soa
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetStudentsCoursesResponse }
     * 
     */
    public GetStudentsCoursesResponse createGetStudentsCoursesResponse() {
        return new GetStudentsCoursesResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByLastNameResponse }
     * 
     */
    public GetStudentsByLastNameResponse createGetStudentsByLastNameResponse() {
        return new GetStudentsByLastNameResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByFirstNameResponse }
     * 
     */
    public GetStudentsByFirstNameResponse createGetStudentsByFirstNameResponse() {
        return new GetStudentsByFirstNameResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByFacultyResponse }
     * 
     */
    public GetStudentsByFacultyResponse createGetStudentsByFacultyResponse() {
        return new GetStudentsByFacultyResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByAgeResponse }
     * 
     */
    public GetStudentsByAgeResponse createGetStudentsByAgeResponse() {
        return new GetStudentsByAgeResponse();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse }
     * 
     */
    public GetAllStudentsResponse createGetAllStudentsResponse() {
        return new GetAllStudentsResponse();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link DeleteStudent }
     * 
     */
    public DeleteStudent createDeleteStudent() {
        return new DeleteStudent();
    }

    /**
     * Create an instance of {@link DeleteStudentResponse }
     * 
     */
    public DeleteStudentResponse createDeleteStudentResponse() {
        return new DeleteStudentResponse();
    }

    /**
     * Create an instance of {@link GetAllStudents }
     * 
     */
    public GetAllStudents createGetAllStudents() {
        return new GetAllStudents();
    }

    /**
     * Create an instance of {@link GetBase64Avatar }
     * 
     */
    public GetBase64Avatar createGetBase64Avatar() {
        return new GetBase64Avatar();
    }

    /**
     * Create an instance of {@link GetBase64AvatarResponse }
     * 
     */
    public GetBase64AvatarResponse createGetBase64AvatarResponse() {
        return new GetBase64AvatarResponse();
    }

    /**
     * Create an instance of {@link GetStudentByIdx }
     * 
     */
    public GetStudentByIdx createGetStudentByIdx() {
        return new GetStudentByIdx();
    }

    /**
     * Create an instance of {@link GetStudentByIdxResponse }
     * 
     */
    public GetStudentByIdxResponse createGetStudentByIdxResponse() {
        return new GetStudentByIdxResponse();
    }

    /**
     * Create an instance of {@link GetStudentsByAge }
     * 
     */
    public GetStudentsByAge createGetStudentsByAge() {
        return new GetStudentsByAge();
    }

    /**
     * Create an instance of {@link GetStudentsByFaculty }
     * 
     */
    public GetStudentsByFaculty createGetStudentsByFaculty() {
        return new GetStudentsByFaculty();
    }

    /**
     * Create an instance of {@link GetStudentsByFirstName }
     * 
     */
    public GetStudentsByFirstName createGetStudentsByFirstName() {
        return new GetStudentsByFirstName();
    }

    /**
     * Create an instance of {@link GetStudentsByLastName }
     * 
     */
    public GetStudentsByLastName createGetStudentsByLastName() {
        return new GetStudentsByLastName();
    }

    /**
     * Create an instance of {@link GetStudentsCourses }
     * 
     */
    public GetStudentsCourses createGetStudentsCourses() {
        return new GetStudentsCourses();
    }

    /**
     * Create an instance of {@link UpdateStudent }
     * 
     */
    public UpdateStudent createUpdateStudent() {
        return new UpdateStudent();
    }

    /**
     * Create an instance of {@link UpdateStudentResponse }
     * 
     */
    public UpdateStudentResponse createUpdateStudentResponse() {
        return new UpdateStudentResponse();
    }

    /**
     * Create an instance of {@link Course }
     * 
     */
    public Course createCourse() {
        return new Course();
    }

    /**
     * Create an instance of {@link Dormitory }
     * 
     */
    public Dormitory createDormitory() {
        return new Dormitory();
    }

    /**
     * Create an instance of {@link Organization }
     * 
     */
    public Organization createOrganization() {
        return new Organization();
    }

    /**
     * Create an instance of {@link Publication }
     * 
     */
    public Publication createPublication() {
        return new Publication();
    }

    /**
     * Create an instance of {@link Student.Courses }
     * 
     */
    public Student.Courses createStudentCourses() {
        return new Student.Courses();
    }

    /**
     * Create an instance of {@link GetStudentsCoursesResponse.Courses }
     * 
     */
    public GetStudentsCoursesResponse.Courses createGetStudentsCoursesResponseCourses() {
        return new GetStudentsCoursesResponse.Courses();
    }

    /**
     * Create an instance of {@link GetStudentsByLastNameResponse.Students }
     * 
     */
    public GetStudentsByLastNameResponse.Students createGetStudentsByLastNameResponseStudents() {
        return new GetStudentsByLastNameResponse.Students();
    }

    /**
     * Create an instance of {@link GetStudentsByFirstNameResponse.Students }
     * 
     */
    public GetStudentsByFirstNameResponse.Students createGetStudentsByFirstNameResponseStudents() {
        return new GetStudentsByFirstNameResponse.Students();
    }

    /**
     * Create an instance of {@link GetStudentsByFacultyResponse.Students }
     * 
     */
    public GetStudentsByFacultyResponse.Students createGetStudentsByFacultyResponseStudents() {
        return new GetStudentsByFacultyResponse.Students();
    }

    /**
     * Create an instance of {@link GetStudentsByAgeResponse.Students }
     * 
     */
    public GetStudentsByAgeResponse.Students createGetStudentsByAgeResponseStudents() {
        return new GetStudentsByAgeResponse.Students();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse.Students }
     * 
     */
    public GetAllStudentsResponse.Students createGetAllStudentsResponseStudents() {
        return new GetAllStudentsResponse.Students();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "deleteStudent")
    public JAXBElement<DeleteStudent> createDeleteStudent(DeleteStudent value) {
        return new JAXBElement<DeleteStudent>(_DeleteStudent_QNAME, DeleteStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "deleteStudentResponse")
    public JAXBElement<DeleteStudentResponse> createDeleteStudentResponse(DeleteStudentResponse value) {
        return new JAXBElement<DeleteStudentResponse>(_DeleteStudentResponse_QNAME, DeleteStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getAllStudents")
    public JAXBElement<GetAllStudents> createGetAllStudents(GetAllStudents value) {
        return new JAXBElement<GetAllStudents>(_GetAllStudents_QNAME, GetAllStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getAllStudentsResponse")
    public JAXBElement<GetAllStudentsResponse> createGetAllStudentsResponse(GetAllStudentsResponse value) {
        return new JAXBElement<GetAllStudentsResponse>(_GetAllStudentsResponse_QNAME, GetAllStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBase64Avatar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBase64Avatar }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getBase64Avatar")
    public JAXBElement<GetBase64Avatar> createGetBase64Avatar(GetBase64Avatar value) {
        return new JAXBElement<GetBase64Avatar>(_GetBase64Avatar_QNAME, GetBase64Avatar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBase64AvatarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBase64AvatarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getBase64AvatarResponse")
    public JAXBElement<GetBase64AvatarResponse> createGetBase64AvatarResponse(GetBase64AvatarResponse value) {
        return new JAXBElement<GetBase64AvatarResponse>(_GetBase64AvatarResponse_QNAME, GetBase64AvatarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByIdx }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentByIdx }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentByIdx")
    public JAXBElement<GetStudentByIdx> createGetStudentByIdx(GetStudentByIdx value) {
        return new JAXBElement<GetStudentByIdx>(_GetStudentByIdx_QNAME, GetStudentByIdx.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByIdxResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentByIdxResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentByIdxResponse")
    public JAXBElement<GetStudentByIdxResponse> createGetStudentByIdxResponse(GetStudentByIdxResponse value) {
        return new JAXBElement<GetStudentByIdxResponse>(_GetStudentByIdxResponse_QNAME, GetStudentByIdxResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByAge }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByAge }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByAge")
    public JAXBElement<GetStudentsByAge> createGetStudentsByAge(GetStudentsByAge value) {
        return new JAXBElement<GetStudentsByAge>(_GetStudentsByAge_QNAME, GetStudentsByAge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByAgeResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByAgeResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByAgeResponse")
    public JAXBElement<GetStudentsByAgeResponse> createGetStudentsByAgeResponse(GetStudentsByAgeResponse value) {
        return new JAXBElement<GetStudentsByAgeResponse>(_GetStudentsByAgeResponse_QNAME, GetStudentsByAgeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByFaculty }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByFaculty }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByFaculty")
    public JAXBElement<GetStudentsByFaculty> createGetStudentsByFaculty(GetStudentsByFaculty value) {
        return new JAXBElement<GetStudentsByFaculty>(_GetStudentsByFaculty_QNAME, GetStudentsByFaculty.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByFacultyResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByFacultyResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByFacultyResponse")
    public JAXBElement<GetStudentsByFacultyResponse> createGetStudentsByFacultyResponse(GetStudentsByFacultyResponse value) {
        return new JAXBElement<GetStudentsByFacultyResponse>(_GetStudentsByFacultyResponse_QNAME, GetStudentsByFacultyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByFirstName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByFirstName }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByFirstName")
    public JAXBElement<GetStudentsByFirstName> createGetStudentsByFirstName(GetStudentsByFirstName value) {
        return new JAXBElement<GetStudentsByFirstName>(_GetStudentsByFirstName_QNAME, GetStudentsByFirstName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByFirstNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByFirstNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByFirstNameResponse")
    public JAXBElement<GetStudentsByFirstNameResponse> createGetStudentsByFirstNameResponse(GetStudentsByFirstNameResponse value) {
        return new JAXBElement<GetStudentsByFirstNameResponse>(_GetStudentsByFirstNameResponse_QNAME, GetStudentsByFirstNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByLastName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByLastName }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByLastName")
    public JAXBElement<GetStudentsByLastName> createGetStudentsByLastName(GetStudentsByLastName value) {
        return new JAXBElement<GetStudentsByLastName>(_GetStudentsByLastName_QNAME, GetStudentsByLastName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsByLastNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsByLastNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsByLastNameResponse")
    public JAXBElement<GetStudentsByLastNameResponse> createGetStudentsByLastNameResponse(GetStudentsByLastNameResponse value) {
        return new JAXBElement<GetStudentsByLastNameResponse>(_GetStudentsByLastNameResponse_QNAME, GetStudentsByLastNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsCourses }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsCourses }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsCourses")
    public JAXBElement<GetStudentsCourses> createGetStudentsCourses(GetStudentsCourses value) {
        return new JAXBElement<GetStudentsCourses>(_GetStudentsCourses_QNAME, GetStudentsCourses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentsCoursesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentsCoursesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "getStudentsCoursesResponse")
    public JAXBElement<GetStudentsCoursesResponse> createGetStudentsCoursesResponse(GetStudentsCoursesResponse value) {
        return new JAXBElement<GetStudentsCoursesResponse>(_GetStudentsCoursesResponse_QNAME, GetStudentsCoursesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "updateStudent")
    public JAXBElement<UpdateStudent> createUpdateStudent(UpdateStudent value) {
        return new JAXBElement<UpdateStudent>(_UpdateStudent_QNAME, UpdateStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://api.soa.agh.edu.pl/", name = "updateStudentResponse")
    public JAXBElement<UpdateStudentResponse> createUpdateStudentResponse(UpdateStudentResponse value) {
        return new JAXBElement<UpdateStudentResponse>(_UpdateStudentResponse_QNAME, UpdateStudentResponse.class, null, value);
    }

}
