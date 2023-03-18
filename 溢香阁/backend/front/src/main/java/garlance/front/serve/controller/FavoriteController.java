package garlance.front.serve.controller;

import garlance.common.result.R;
import garlance.front.serve.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Favorite")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping("/House")
    public R F(@RequestParam String HouseID,@RequestParam String UserID,@RequestParam String Status){
        System.out.println(HouseID);
        System.out.println(UserID);
        System.out.println(Status);
        return R.success(favoriteService.update(HouseID,UserID,Status));
    }
}
