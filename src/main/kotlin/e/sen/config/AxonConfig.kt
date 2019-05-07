package e.sen.config

import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.disruptor.commandhandling.DisruptorCommandBus
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore
import org.axonframework.eventsourcing.eventstore.EventStorageEngine
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine
import org.axonframework.spring.config.AxonConfiguration
import org.springframework.beans.factory.annotation.Qualifier
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
class AxonConfig {

    @Bean
    fun eventStorageEngine(): EventStorageEngine {
        return InMemoryEventStorageEngine()
    }

    @Bean
    fun eventStore(storageEngine: EventStorageEngine, configuration: AxonConfiguration): EmbeddedEventStore {
        return EmbeddedEventStore.builder()
                .storageEngine(storageEngine)
                .messageMonitor(configuration.messageMonitor(EventStore::class.java, "eventStore"))
                .build()
    }


    @Bean
    @Profile("simple")
    fun simpleCommandBus(): CommandBus {
        return SimpleCommandBus.builder().build()
    }

    @Bean
    @Profile("disruptor")
    fun disruptorCommandBus(): DisruptorCommandBus {
        return DisruptorCommandBus.builder().build()
    }

}