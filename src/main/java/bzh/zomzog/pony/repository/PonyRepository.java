package bzh.zomzog.pony.repository;

import bzh.zomzog.pony.domain.Pony;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Zomzog on 25/09/2017.
 */
public interface PonyRepository extends JpaRepository<Pony, Long> {
}
