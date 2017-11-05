package bzh.zomzog.pony.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Size(min = 1, max = 256)
    @Column(name = "name", length = 256, nullable = false)
    private String name;

    public Pony(String name){
        this.name = name;
    }
}
