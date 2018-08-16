package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Greeting {


    public Map getMap() {
        Map<String,String>map =new HashMap<>();
        map.put("hello", "xin chao");
        map.put("bye", "tam biet");
        map.put("good", "tot");
        map.put("tea", "che");
        return map;
    }
    @GetMapping("/getword")
    public String getWord() {
        return "index";
    }
    @GetMapping("/search")
    public String search(@RequestParam String word, Model model) {
        Map<String, String> map = getMap();
        String search="";
        for (String s : map.keySet()) {
            System.out.println(s);
            if (word.equalsIgnoreCase(s)) {
                search = map.get(s);
                break;
            }  else {
                search = "Not found";
            }
        }
        model.addAttribute("search", search);

//        if (map.containsKey(word)) {
//            model.addAttribute("search", map.get(word));
//        } else {
//            model.addAttribute("fail", "not found");
//        }
        return "search";
    }

    @GetMapping("/vietsearch")
    public String getword(@RequestParam String word, Model model) {
        Map<String, String> hashmap = new HashMap<>();
        hashmap.put("ong", "bee");
        hashmap.put("dong", "close");
        String search = null;
        for (String s : hashmap.keySet()) {
            if (word.equals(s)) {
                search = hashmap.get(s);
                break;
            } else {
                search = "Not found";
            }
        }
        model.addAttribute("search", search);
        model.addAttribute("mean",word);
        return "vietnamese";
    }

}
