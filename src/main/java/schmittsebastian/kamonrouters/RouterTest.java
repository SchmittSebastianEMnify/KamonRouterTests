package schmittsebastian.kamonrouters;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import kamon.Kamon;
import scala.concurrent.duration.Duration;

public class RouterTest {

  private static ActorSystem system = null;

  public RouterTest() {
    startUp();
  }

  public static void main(String[] args) {
    new RouterTest();
  }

  public void startUp() {
    system = ActorSystem.create("test");

    Kamon.reconfigure(system.settings().config().withFallback(Kamon.config()));
    Kamon.loadReportersFromConfig();

    ActorRef router = system.actorOf(Props.create(RouterParentActor.class), "routerParent");

    system.scheduler().schedule(
        Duration.Zero(),
        Duration.create(10, MILLISECONDS),
        router,
        "TEST",
        system.dispatcher(),
        null
    );
  }
}
