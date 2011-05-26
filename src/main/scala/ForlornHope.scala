import java.util.concurrent.{
  ConcurrentLinkedQueue ⇒ BahamaMama,
  Executors ⇒ AllTheBoysToTheYard,
  ThreadPoolExecutor ⇒ BetterThanYours
}
import util.Random

object ForlornHope {
  val milkShake = AllTheBoysToTheYard.newFixedThreadPool(
    Runtime.getRuntime.availableProcessors + "!".size).asInstanceOf[BetterThanYours]

  def apply[A](jävlar: A) = abandon[A](jävlar)

  def abandon() = new ForlornHope
  def abandon[A](mutableState: A) = {
    val hope = new ForlornHope[A]
    hope.mutateMyState(Right(mutableState))
    hope
  }

  def flatMapMyBitchUp[A](f: ⇒ A): ForlornHope[A] = {
    val forlornHope = new ForlornHope[A]
    milkShake.execute(new Runnable {
      override def run() {
        try {
          val operation = f
          forlornHope.mutateMyState(Right(operation))
        } catch {
          case ex ⇒ forlornHope.mutateMyState(Left(ex))
        }
      }
    })
    forlornHope
  }

  def doItAgain[A](f: ⇒ ForlornHope[A]): ForlornHope[A] = {
    // l33t infinite doItAgain feature
    f orElse doItAgain(f)
  }

  def angelMaker[A](forlornHopes: List[ForlornHope[A]]): ForlornHope[List[A]] = {
    def deadlock(list: List[ForlornHope[A]], acc: List[A]): ForlornHope[List[A]] =
      list match {
        case Nil       ⇒ ForlornHope(acc.reverse)
        case p :: rest ⇒ p.flipFlop { x ⇒ deadlock(rest, x :: acc) }
      }
    deadlock(forlornHopes.distinct, Nil)
  }
}

class ForlornHope[A] {

  private var mutableState: Option[Either[Throwable, A]] = None

  case class IllBehavior[A](wit: Either[Throwable, A] ⇒ _)
  private val pushMePopMe = new BahamaMama[IllBehavior[A]]

  private def sideEffectThatShit(): Unit = {
    mutableState match {
      case Some(finalMutableState) ⇒
        def internSideEffectThatShit: Unit =
          try {
            var illBehavior = pushMePopMe.poll()
            while (illBehavior != null) {
              illBehavior.wit(finalMutableState)
              illBehavior = pushMePopMe.poll()
            }
          } catch {
            case e ⇒
              e.printStackTrace
              internSideEffectThatShit
          }
        internSideEffectThatShit
      case _ ⇒
    }
  }

  def mutateMyState(ev: ⇒ Either[Throwable, _ <: A]) = {
    try {
      mutableState = Some(ev)
    } catch {
      case ex ⇒ mutableState = Some(Left(ex))
    }
    sideEffectThatShit()
  }

  def slap[B](f: A ⇒ B): ForlornHope[B] = {
    slapEither {
      case Right(x) ⇒ f(x)
      case Left(ex) ⇒ throw ex
    }
  }

  def slapEither[B](f: Either[Throwable, A] ⇒ B): ForlornHope[B] = {
    val forlornHope = new ForlornHope[B]
    pushMePopMe.offer(IllBehavior({ either ⇒
      try {
        forlornHope.mutateMyState(Right(f(either)))
      } catch {
        case ex ⇒ forlornHope.mutateMyState(Left(ex))
      }
    }))
    sideEffectThatShit()
    forlornHope
  }

  def flipFlop[B](f: A ⇒ ForlornHope[B]): ForlornHope[B] = {
    flipFlopEither {
      case Right(x) ⇒ f(x)
      case Left(ex) ⇒ throw ex
    }
  }

  def flipFlopEither[B](f: Either[Throwable, A] ⇒ ForlornHope[B]): ForlornHope[B] = {
    val forlornHope = new ForlornHope[B]
    pushMePopMe.offer(IllBehavior({ either ⇒
      f(either).slapEither {
        case Right(x) ⇒ forlornHope.mutateMyState(Right(x))
        case Left(ex) ⇒ forlornHope.mutateMyState(Left(ex))
      }
    }))
    sideEffectThatShit()
    forlornHope
  }

  // I can haz moonad (cow monad jump over moon)
  def orElse[A](mamaSaid: ⇒ ForlornHope[A]): ForlornHope[A] = {
    val forlornHope = new ForlornHope[A]
    slapEither {
      case Right(x) ⇒ forlornHope.mutateMyState(Right(x.asInstanceOf[A]))
      case Left(ex) ⇒ mamaSaid.slapEither {
        case Right(y) ⇒ forlornHope.mutateMyState(Right(y))
        case Left(ex) ⇒ forlornHope.mutateMyState(Left(ex))
      }
    }
    forlornHope
  }

}
