package e.sen.config

import e.sen.aggregate.User
import org.axonframework.commandhandling.CommandBus
import org.axonframework.disruptor.commandhandling.DisruptorCommandBus
import org.axonframework.eventsourcing.AggregateFactory
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.GenericAggregateFactory
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.modelling.command.Repository
import org.axonframework.springboot.util.ConditionalOnQualifiedBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

/**
 *   @Project: axon-disruptor-demo
 *   @Package: e.sen.config
 *   @Author:  Iamee
 *   @Date:    2019-05-07 17:16
 */

@Configuration
class AggregateConfig {

    @Bean
    fun userAggregateFactory(): AggregateFactory<User> {
        return GenericAggregateFactory(User::class.java)
    }

    @Bean
    @Profile("simple")
    fun userSimpleRepository(eventStore: EventStore, aggregateFactory: AggregateFactory<User>): Repository<User> {
        return EventSourcingRepository.builder(User::class.java).eventStore(eventStore).aggregateFactory(aggregateFactory).build()
    }

    @Bean
    @Profile("disruptor")
    fun userDisruptorRepository(commandBus: DisruptorCommandBus, eventStore: EventStore, aggregateFactory: AggregateFactory<User>): Repository<User> {
        return commandBus.createRepository(eventStore, aggregateFactory)
    }

}