package garlance.front.serve.responseEntity;

import garlance.front.serve.entity.HouseEntity;
import lombok.Data;

@Data
public class HouseListResponseEntity {

    private HouseEntity houseEntity;

    //是否收藏
    private String isFavorite;

}
