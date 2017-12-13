package bzh.zomzog.pony.web.rest;

import bzh.zomzog.pony.domain.Pony;
import bzh.zomzog.pony.repository.PonyRepository;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.test.Deployment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Zomzog on 25/09/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PonyControllerTest {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private PonyRepository ponyRepository;


    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final PonyController ponyController = new PonyController(runtimeService, historyService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(ponyController)
                .build();
    }

    @Test
    public void sayHello() throws Exception {
        // Init
        Pony pony = new Pony("Daring Do");
        pony = ponyRepository.save(pony);
        // Do
        this.mockMvc.perform(post("/ponies/{ponyId}/sayHello", pony.getId()))
                // Validate
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Hello Daring Do"));
        // Teardown
        ponyRepository.delete(pony.getId());
    }

    @Test
    public void sayEeyup() throws Exception {
        // Init
        Pony pony = new Pony("Big McIntosh");
        pony = ponyRepository.save(pony);
        // Do
        this.mockMvc.perform(post("/ponies/{ponyId}/sayHello", pony.getId()))
                // Validate
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Eeyup"));
        // Teardown
        ponyRepository.delete(pony.getId());
    }

}