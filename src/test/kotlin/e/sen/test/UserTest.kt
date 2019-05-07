package e.sen.test

import e.sen.AxonDisruptorDemoApplication
import e.sen.aggregate.User
import e.sen.command.CreateUserCommand
import org.axonframework.commandhandling.CommandBus
import org.axonframework.commandhandling.SimpleCommandBus
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.commandhandling.gateway.DefaultCommandGateway
import org.axonframework.common.IdentifierFactory
import org.axonframework.disruptor.commandhandling.DisruptorCommandBus
import org.axonframework.eventsourcing.AggregateFactory
import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.eventsourcing.eventstore.EventStore
import org.axonframework.modelling.command.Repository
import org.axonframework.springboot.util.ConditionalOnQualifiedBean
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.context.annotation.Profile
import org.springframework.test.context.junit4.SpringRunner

/**
 *   @Project: axon-disruptor-demo
 *   @Package: e.sen.test
 *   @Author:  Iamee
 *   @Date:    2019-05-07 17:00
 */

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [AxonDisruptorDemoApplication::class])
class UserTest {

    @Autowired
    lateinit var commandGateway: CommandGateway

    @Test
    fun createUser() {

        val userId = IdentifierFactory.getInstance().generateIdentifier()

        val result = commandGateway.sendAndWait<String>(CreateUserCommand(userId = userId))

        Assert.assertEquals(result, userId)

    }

}