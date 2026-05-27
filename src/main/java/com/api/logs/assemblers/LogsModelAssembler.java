package com.api.logs.assemblers;

import com.api.logs.domain.logs.Logs;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class LogsModelAssembler implements RepresentationModelAssembler<Logs, EntityModel<Logs>> {
    @Override
    public EntityModel<Logs> toModel(Logs entity) {
        try{
            EntityModel<Logs> logsEntityModel = EntityModel.of(entity);

            return logsEntityModel;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
