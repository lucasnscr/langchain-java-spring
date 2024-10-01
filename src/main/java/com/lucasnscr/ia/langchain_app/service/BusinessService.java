package com.lucasnscr.ia.langchain_app.service;

import lombok.extern.slf4j.Slf4j;
import dev.langchain4j.chain.ConversationalRetrievalChain;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BusinessService {

    private final ConversationalRetrievalChain chain;

    public BusinessService(ConversationalRetrievalChain chain) {
        this.chain = chain;
    }

    public String askQuestion(String question) {
        log.debug("======================================================");
        log.debug("Question: " + question);
        String answer = chain.execute(question);
        log.debug("Answer: " + answer);
        log.debug("======================================================");
        return answer;
    }

}
