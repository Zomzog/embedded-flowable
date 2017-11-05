package bzh.zomzog.pony.web.rest;

import bzh.zomzog.pony.domain.Message;
import org.flowable.engine.HistoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.variable.api.history.HistoricVariableInstance;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ponies")
public class PonyController {

    private RuntimeService runtimeService;
    private HistoryService historyService;

    public PonyController(final RuntimeService runtimeService, final HistoryService historyService) {
        this.runtimeService = runtimeService;
        this.historyService = historyService;
    }

    @PostMapping("/{ponyId}/sayHello")
    public ResponseEntity<Message> sayHello(@PathVariable("ponyId") Long ponyId) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("ponyId", ponyId);
        final ProcessInstance process = runtimeService.startProcessInstanceByKey("sayHello", variables);
        final HistoricVariableInstance hvi = historyService.createHistoricVariableInstanceQuery().processInstanceId(process.getId()).variableName("result").singleResult();
        Message message = (Message) hvi.getValue();
        return ResponseEntity.ok(message);
    }
}
