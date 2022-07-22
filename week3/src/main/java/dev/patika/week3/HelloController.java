package dev.patika.week3;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    // endpoint
    //@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @RequestMapping(value="/hello")
    public StringResponse sayHello(@RequestParam(required = false) String name, @RequestParam int year) {
        return new StringResponse("Hello " + name + " , from " + year);
    }

    @RequestMapping("/hello/{name}/{year}")
    @ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT, reason = "There is an error during request...")
    public String sayMyName(@PathVariable(required = false) String name, @PathVariable(required = false) int year) {
        return "Hello " + name + " , from " + year;
    }

    @GetMapping("/greeting/{id}")
    public ResponseEntity<String> greeting(@RequestHeader("Connection") String connection, @PathVariable int id) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("my-custom-header","test header");


        //return new ResponseEntity<>("Id : " + id + " , connection: " + connection, HttpStatus.OK );
        //return ResponseEntity.ok().body("Id : " + id + " , connection: " + connection);
        //return ResponseEntity.status(HttpStatus.ACCEPTED).body("Id : " + id + " , connection: " + connection);
        return new ResponseEntity<>("Id : " + id + " , connection: " + connection, headers, HttpStatus.OK );
    }

    @GetMapping("/custom")
    public void customHeader(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String connection = request.getHeader("connection");

        response.setHeader("custom header", "Selin");
        response.setHeader("connection" ,connection + "patikadev");
        response.setStatus(201);
        response.getWriter().println("Hello World...");
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Selin Atlı",28));
        students.add(new Student(2,"Zeynep Elis",27));
        students.add(new Student(3,"İrem Onur",25));

        return ResponseEntity.ok().body(students);


    }
}
