package e.sen.handler

import e.sen.command.CreateUserCommand
import e.sen.aggregate.User
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.modelling.command.Repository
import org.springframework.stereotype.Component

/**
 *   @Project: axon-disruptor-demo
 *   @Package: e.sen
 *   @Author:  Iamee
 *   @Date:    2019-05-07 16:57
 */

@Component
class UserCommandHandler(
        val repository: Repository<User>
) {

    @CommandHandler
    fun handle(command: CreateUserCommand): String {
        repository.newInstance {
            User(userId = command.userId)
        }
        return command.userId
    }

}