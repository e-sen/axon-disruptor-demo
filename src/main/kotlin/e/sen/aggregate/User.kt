package e.sen.aggregate

import e.sen.event.UserCreatedEvent
import org.axonframework.eventhandling.EventHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.modelling.command.AggregateLifecycle
import org.axonframework.spring.stereotype.Aggregate

/**
 *   @Project: axon-disruptor-demo
 *   @Package: e.sen
 *   @Author:  Iamee
 *   @Date:    2019-05-07 16:54
 */

@Aggregate
class User {

    @AggregateIdentifier
    lateinit var userId: String

    constructor()

    constructor(userId: String) {
        AggregateLifecycle.apply(UserCreatedEvent(userId = userId))
    }

    @EventHandler
    fun on(event: UserCreatedEvent) {
        this.userId = event.userId
    }

}