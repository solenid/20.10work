package com.example.work;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//

//

//

//

//

//

@Controller
@RestController
public class ApiControl {
    private List<String> themes = new ArrayList<>();
    private List<ArrayList> comms = new ArrayList<>();
    //curl -X GET http://localhost:8080/themes
    @GetMapping("themes")
    public List<String> getThemes() {
        return themes;
    }
    //curl -X GET http://localhost:8080/themes/0/comms
    @GetMapping("themes/{index}/comms")
    public List<String> getComms(@PathVariable("index") Integer i) {
        return comms.get(i);
    }
    //curl -X POST -d "gege" http://localhost:8080/themes
    @PostMapping("themes")
    public void addTheme(@RequestBody String text) {
        themes.add(text);
        comms.add(new ArrayList<String>());
    }
    //curl -X POST -d "newcomm" http://localhost:8080/themes/comm/0
    @PostMapping("themes/comm/{index}")
    public void addComm(@PathVariable("index") Integer i,
                        @RequestBody String text){
        comms.get(i).add(text);
    }
    //curl -X GET http://localhost:8080/themes/0
    @GetMapping("themes/{index}")
    public String getTheme(@PathVariable("index") Integer index) {
        return themes.get(index);
    }
    //curl -X GET http://localhost:8080/themes/count
    @GetMapping("themes/count")
    public int getCount(){
        return themes.size();
    }
    //curl -X DELETE http://localhost:8080/themes/0/dcomm/0
    @DeleteMapping("themes/{index1}/dcomm/{index2}")
    public void deleteComm(@PathVariable("index1") Integer i1, @PathVariable("index2") Integer i2){
        comms.get(i1).remove(i2);
    }
    //curl -X DELETE http://localhost:8080/themes/0
    @DeleteMapping("themes/{index}")
    public void deleteText(@PathVariable("index") Integer index) {
        themes.remove((int) index);
        comms.remove((int) index);
    }
    //curl -X DELETE http://localhost:8080/themes/dall
    @DeleteMapping("themes/dall")
    public void deleteAll(){
        for(int i=0;i<themes.size()+1;i++){
            themes.remove((int) i);
            comms.remove((int) i);
        }
    }
    //curl -X PUT -d "UPDCOMM" http://localhost:8080/themes/0/comms/0
    @PutMapping("themes/{index1}/comms/{index2}")
    public void updateComm(
            @PathVariable("index1") Integer i1, @PathVariable("index2") Integer i2,
            @RequestBody String comm) {
        comms.get(i1).remove(i2);
        comms.get(i1).add(i2,comm);
    }
    //curl -X PUT -d "UPDTHEME" http://localhost:8080/themes/0
    @PutMapping("themes/{index}")
    public void updateTheme(
            @PathVariable("index") Integer i,
            @RequestBody String theme) {
        themes.remove((int) i);
        themes.add(i, theme);
    }


//    8.      Создать комментарий в определенной теме
//
//9.      Удалить комментарий из определенной темы
//
//10.   Обновить комментарий в определенной теме

//11.   Выдать список комментариев определенной темы
}