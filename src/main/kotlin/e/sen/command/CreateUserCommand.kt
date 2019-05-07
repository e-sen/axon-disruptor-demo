package e.sen.command

import org.axonframework.modelling.command.TargetAggregateIdentifier

/**
 *   @Project: axon-disruptor-demo
 *   @Package: e.sen
 *   @Author:  Iamee
 *   @Date:    2019-05-07 16:55
 */

data class CreateUserCommand(@TargetAggregateIdentifier val userId: String)