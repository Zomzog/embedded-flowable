package bzh.zomzog.pony.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by Zomzog on 24/09/2017.
 */
@Entity
@Data
@NoArgsConstructor
public class Pony implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    public Pony(String name){
        this.name = name;
    }
}
