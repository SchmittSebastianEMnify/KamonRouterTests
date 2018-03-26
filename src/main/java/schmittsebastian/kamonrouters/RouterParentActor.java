package schmittsebastian.kamonrouters;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.FromConfig;

public class RouterParentActor extends AbstractActor {

  private final ActorRef router;

  public RouterParentActor() {
    router =
        getContext().actorOf(FromConfig.getInstance().props(Props.create(RouteeActor.class)),
            "router");
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder()
        .matchAny(a -> router.forward(a, getContext()))
        .build();
  }
}
