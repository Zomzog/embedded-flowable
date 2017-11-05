package bzh.zomzog.pony.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Zomzog on 05/11/2017.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {
    private String message;
}
