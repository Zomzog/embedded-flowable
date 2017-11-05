package bzh.zomzog.pony.services;

import bzh.zomzog.pony.domain.Message;
import bzh.zomzog.pony.domain.Pony;
import bzh.zomzog.pony.exception.FunctionalException;
import bzh.zomzog.pony.repository.PonyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Zomzog on 24/09/2017.
 */
@Service
@Transactional
public class PonyService {
    private PonyRepository ponyRepository;

    public PonyService(final PonyRepository ponyRepository) {
        this.ponyRepository = ponyRepository;
    }


    public Pony getOne(long id) throws FunctionalException {
        return ponyRepository.findOne(id);
    }

    public Message sayEeyup(){
        return new Message("Eeyup");
    }

    public Message sayHello(Pony pony){
        return new Message("Hello " + pony.getName());
    }
}
