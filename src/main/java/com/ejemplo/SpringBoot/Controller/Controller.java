
package com.ejemplo.SpringBoot.Controller;


import com.ejemplo.SpringBoot.Autentication.AuthRequest;
import com.ejemplo.SpringBoot.Autentication.AuthResponse;
import com.ejemplo.SpringBoot.Jwt.JwtTokenUtil;
import com.ejemplo.SpringBoot.model.Educacion;
import com.ejemplo.SpringBoot.model.Experiencia;
import com.ejemplo.SpringBoot.model.HabTech;
import com.ejemplo.SpringBoot.model.Habilidad;
import com.ejemplo.SpringBoot.model.HabilidadBlanda;
import java.util.ArrayList;
import java.util.List;
import com.ejemplo.SpringBoot.model.Persona;
import com.ejemplo.SpringBoot.model.Proyecto;
import com.ejemplo.SpringBoot.model.Tecnologia;
import com.ejemplo.SpringBoot.model.Usuario;
import com.ejemplo.SpringBoot.service.IEducacionService;
import com.ejemplo.SpringBoot.service.IExperienciaService;
import com.ejemplo.SpringBoot.service.IHabilidadBlandaService;
import com.ejemplo.SpringBoot.service.IHabilidadService;
import com.ejemplo.SpringBoot.service.IPersonaService;
import com.ejemplo.SpringBoot.service.IProyectoService;
import com.ejemplo.SpringBoot.service.ITecnologiaService;
import com.ejemplo.SpringBoot.service.IUsuarioService;
//import static com.mysql.cj.conf.PropertyKey.logger;
import java.lang.System.Logger;
import java.util.concurrent.atomic.AtomicLong;
import javax.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    //Inyectamos la dependecnia de Service de los objetos
    @Autowired
    private IPersonaService persoServ;
    @Autowired
    private IExperienciaService experienciaServ;
    @Autowired
    private IEducacionService educacionServ;
    @Autowired
    private IProyectoService proyectoServ;
    @Autowired
    private IHabilidadService habilidadServ;
    @Autowired
    private IHabilidadBlandaService habilidadBlandaServ;
    @Autowired
    private ITecnologiaService tecnologiaServ;
    @Autowired
    private IUsuarioService usuarioServ;
    
    //Para gestionar si un usuario pertenece a la BD o no
    @Autowired
    private AuthenticationManager authManager;
    
    //Para generar y obtener el token, creado con el método JwtTokenUtil
    @Autowired
    private JwtTokenUtil jwtUtil;

     
        
    //API PARA LA PERSONA
    //METODO POST (agrega un persona con los parametro recibidos)
    @PostMapping ("/nueva/persona")
    public void agregarPersona(@RequestBody Persona pers){
        persoServ.crearPersona(pers);        
    }
    
    //METODO GET para ver la persona creada con el POST anterior
    
    @GetMapping ("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas(){
       
        
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return persoServ.verPersonas();
    }
    
    @GetMapping ("/ver/persona/{id}")
    @ResponseBody
    public Persona buscarPersona(@PathVariable Long id){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return persoServ.buscarPersona(id);
    }
    
    //METODO DELETE para borrar persona segun la id
    @DeleteMapping ("/borrar-persona/{id}")
    public void borrarPersona (@PathVariable Long id){
        persoServ.borrarPersona(id);
    }
    
    //METODO POST edita un persona, la sobreescribe
    @PutMapping ("/editar/persona")
    public void modificarPersona(@RequestBody Persona pers){
        persoServ.modificarPersona(pers);
    }
    
    
    
    
    //API PARA LA EXPERIENCIA
    @PostMapping ("/nueva/experiencia")
    public void agregarExperiencia(@RequestBody Experiencia exper){
        experienciaServ.crearExperiencia(exper);        
    }
    
    @GetMapping ("/ver/experiencia")
    @ResponseBody
    public List<Experiencia> verExperiencias(){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return experienciaServ.verExperiencia();
    }
    
    @GetMapping ("/ver/experiencia/{id}")
    @ResponseBody
    public Experiencia buscarExperiencias(@PathVariable Long id){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return experienciaServ.buscarExperiencia(id);
    }
    
    //Para buscar experiencia segun foreign key
    @GetMapping ("/ver/experiencia-usuario/{id}")
    @ResponseBody
    public List<Experiencia> buscarExperienciaUsuario(@PathVariable Long id){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return experienciaServ.buscarPorUsuarioId(id);
    }
    
    
    @DeleteMapping ("/borrar-experiencia/{id}")
    public void borrarExperiencia (@PathVariable Long id){
        experienciaServ.borrarExperiencia(id);
    }
    
    @PutMapping ("/editar/experiencia")
    public void modificarExperiencia(@RequestBody Experiencia exper){
        experienciaServ.modificarExperiencia(exper);
    }
    
    
    
    //API PARA EDUCACION
    @PostMapping ("/nueva/educacion")
    public void agregarEducacion(@RequestBody Educacion educa){
        educacionServ.crearEducacion(educa);        
    }
    
    @GetMapping ("/ver/educacion-usuario/{id}")
    @ResponseBody
    public List<Educacion> verEducacionPorIdPersona(@PathVariable Long id){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return educacionServ.buscarEducacionPorIdPersona(id);
    }
    
    //GET para buscar educacion segun clave foránea de persona
    @GetMapping ("/ver/educacion")
    @ResponseBody
    public List<Educacion> verEducacion(){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return educacionServ.verEducacion();
    }
    
    @DeleteMapping ("/borrar-educacion/{id}")
    public void borrarEducacion (@PathVariable Long id){
        educacionServ.borrarEducacion(id);
    }
    
    @PutMapping ("/editar/educacion")
    public void modificarEducacion(@RequestBody Educacion educa){
        educacionServ.modificarEducacion(educa);
    }
    
    
    
    
    //API PARA PROYECTO
    @PostMapping ("/nuevo/proyecto")
    public void agregarProyecto(@RequestBody Proyecto proy){
        proyectoServ.crearProyecto(proy);            
    }
    
    @GetMapping ("/ver/proyecto")
    @ResponseBody
    public List<Proyecto> verProyecto(){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return proyectoServ.verProyecto();        
    }
    
    //Método para buscar Proyecto por clave foránea
    @GetMapping ("/ver/proyecto-usuario/{id}")
    @ResponseBody
    public List<Proyecto> buscarProyectoPorIdPersona(@PathVariable Long id){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return proyectoServ.buscarProyectoPorIdPersona(id);        
    }
    
    @DeleteMapping ("/borrar-proyecto/{id}")
    public void borrarProyecto(@PathVariable Long id){
        proyectoServ.borrarProyecto(id);        
    }
    
    @PutMapping ("/editar/proyecto")
    public void modificarProyecto(@RequestBody Proyecto proy){
        proyectoServ.modificarProyecto(proy);        
    }
    
    
      //API PARA HABILIDAD
    @PostMapping ("/nueva/habilidad")
    public void agregarHabilidad(@RequestBody Habilidad habil){
        habilidadServ.crearHabilidad(habil);                   
    }
    
    @GetMapping ("/ver/habilidad")
    @ResponseBody
    public List<Habilidad> verHabilidad(){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio}
        return habilidadServ.verHabilidad();              
    }
    
    @GetMapping ("/ver/habilidad-usuario/{id}")
    @ResponseBody
    public List<HabTech> verHabilidadPorIdPersona(@PathVariable Long id){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio}
        return habilidadServ.buscarHabilidadPorIdPersona(id);              
    }
    
    @DeleteMapping ("/borrar-habilidad/{id}")
    public void borrarHabilidad(@PathVariable Long id){
        habilidadServ.borrarHabilidad(id);              
    }
    
    @PutMapping ("/editar/habilidad")
    public void modificarHabilidad(@RequestBody Habilidad habil){
        habilidadServ.modificarHabilidad(habil);             
    }
    
    
    //API PARA HABILIDAD BLANDA
    @PostMapping ("/nueva/habilidad-blanda")
    public void agregarHabilidadBlanda(@RequestBody HabilidadBlanda habilBlanda){
        habilidadBlandaServ.crearHabilidadBlanda(habilBlanda);                         
    }
    
    @GetMapping ("/ver/habilidad-blanda")
    @ResponseBody
    public List<HabilidadBlanda> verHabilidadBlanda(){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return habilidadBlandaServ.verHabilidadBlanda();                      
    }
    
     @GetMapping ("/ver/habilidad-blanda/{id}")
    @ResponseBody
    public List<HabilidadBlanda> verHabilidadBlandaPorIdPersona(@PathVariable Long id){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return habilidadBlandaServ.buscarHabBlandaPorIdPersona(id);                      
    }
    
    @DeleteMapping ("/borrar-habilidad-blanda/{id}")
    public void borrarHabilidadBlanda(@PathVariable Long id){
        habilidadBlandaServ.borrarHabilidadBlanda(id);                      
    }
    
    @PutMapping ("/editar/habilidad-habilidad")
    public void modificarHabilidadBlanda(@RequestBody HabilidadBlanda habilBlanda){
        habilidadBlandaServ.modificarHabilidadBlanda(habilBlanda);                     
    }
    
    
    //API PARA HABILIDAD TECNOLOGIA
    @PostMapping ("/nueva/tecnologia")
    public void agregarTecnologia(@RequestBody Tecnologia tech){
        tecnologiaServ.crearTecnologia(tech);                                
    }
    
    @GetMapping ("/ver/tecnologia")
    @ResponseBody
    public List<Tecnologia> verTecnologia(){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return tecnologiaServ.verTecnologia();                              
    }
    
    @DeleteMapping ("/tecnologia/{id}")
    public void borrarTecnologia(@PathVariable Long id){
        tecnologiaServ.borrarTecnologia(id);                              
    }
    
    @PutMapping ("/editar/tecnologia")
    public void modificarTecnologia(@RequestBody Tecnologia tech){
        tecnologiaServ.modificarTecnologia(tech);                            
    }
    
    
    
    
    
    //API PARA LOGIN USUARIO
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request){
        try{
            Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            
            Usuario user =(Usuario) authentication.getPrincipal();
            
            //LLamamos al método para generar el token
            String accessToken = jwtUtil.generateAccessToken(user);
            
            //Si la respuesta es exitosa devolvemos una response successfull con el email y el token
       
            AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
            
            return ResponseEntity.ok(response);
            
            
        } catch (BadCredentialsException ex){
        //Si no esta autorizado el usuario, devuelve un estado 401
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
       
    }
    
    
    
    
    
    
    
    @PostMapping ("/nuevo/usuario")
    public void agegarUsuario(@RequestBody Usuario user){
        usuarioServ.crearUsuario(user);                                        
    }
    
    @GetMapping ("/ver/usuario")
    @ResponseBody
    public List<Usuario> verUsuario(){
        //Si devuelve un objeto vacio, automaticamente devuelve un json vacio
        return usuarioServ.verUsuario();                                      
    }
    
    @DeleteMapping ("/usuario/{id}")
    public void borrarUsuario(@PathVariable Long id){
        usuarioServ.borrarUsuario(id);                                      
    }
    
    @PutMapping ("/editar/usuario")
    public void modificarUsuario(@RequestBody Usuario user){
        usuarioServ.modificarUsuario(user);                                    
    }   
    
    
    
    
}


