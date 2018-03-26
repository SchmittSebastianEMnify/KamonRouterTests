package schmittsebastian.kamonrouters;

import akka.actor.AbstractActor;

public class RouteeActor extends AbstractActor {

  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .matchAny(System.err::println)
        .build();
  }
}
