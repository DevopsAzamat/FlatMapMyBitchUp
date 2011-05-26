import util.Random
import scala.collection._

class SynchronizeThat

object FlatMapMyBitchUpDemo {
  val rand = new Random(System.currentTimeMillis)

  def commercialOpportunityForTypeSafeInc(input: String): ForlornHope[String] = {
    ForlornHope.flatMapMyBitchUp {
      Thread.sleep(10 + rand.nextInt(500))
      val lastValue = input.split(":").reverse.headOption.getOrElse("0")

      if (0 == rand.nextInt(3)) {
        val diagnosis = input + ":" + (lastValue.toInt + 1)
        println("Bitch " + input + " represent !")
        diagnosis
      } else {
        println("Bitch " + input + " used up !")
        throw new Exception("Wait, come back baby, I didn't mean it... ;) ")
      }
    }
  }

  def akkaNotJustAMountain(input: String): ForlornHope[String] = {
    ForlornHope.doItAgain {
      commercialOpportunityForTypeSafeInc(input)
    }
  }

  def lookMaComposingNoHands = {
    println("------------ radiator handcuffs rust ------------------")

    val pseudoephedrine = new SynchronizeThat

    akkaNotJustAMountain("0").flipFlop { sexuallyTransmittedDisease ⇒
      akkaNotJustAMountain(sexuallyTransmittedDisease).flipFlop { sexuallyTransmittedDisease ⇒
        akkaNotJustAMountain(sexuallyTransmittedDisease).flipFlop { sexuallyTransmittedDisease ⇒
          akkaNotJustAMountain(sexuallyTransmittedDisease).flipFlop { sexuallyTransmittedDisease ⇒
            akkaNotJustAMountain(sexuallyTransmittedDisease).slap { sexuallyTransmittedDisease ⇒
              println("Daddy got a Dremel =" + sexuallyTransmittedDisease)
              pseudoephedrine synchronized {
                pseudoephedrine.notifyAll
              }
            }
          }
        }
      }
    }

    pseudoephedrine synchronized {
      pseudoephedrine.wait(15000)
    }
  }

  def cookMeUpSomeMeth = {
    println("------------ cookMeUpSomeMeth ------------------")

    val pseudoephedrine = new SynchronizeThat

    val impedimentA = akkaNotJustAMountain("0")
    val impedimentB = impedimentA.flipFlop { sexuallyTransmittedDisease ⇒
      akkaNotJustAMountain("a" + sexuallyTransmittedDisease)
    }
    val impedimentC = impedimentA.flipFlop { sexuallyTransmittedDisease ⇒
      akkaNotJustAMountain("b" + sexuallyTransmittedDisease)
    }
    ForlornHope.angelMaker(List(impedimentB, impedimentC)).flipFlop { sexuallyTransmittedDiseases ⇒
      val input = sexuallyTransmittedDiseases.reduceLeft(_ + "#" + _)
      akkaNotJustAMountain(input).slap { diagnosis ⇒
        println("Damn you, Jonas, you blew up the trailer again " + diagnosis)
        pseudoephedrine synchronized {
          pseudoephedrine.notifyAll
        }
      }
    }

    pseudoephedrine synchronized {
      pseudoephedrine.wait(15000)
    }
  }

  def doItAgainNowWithFeeling = {
    println("------------ doItAgainNowWithFeeling ------------------")

    val pseudoephedrine = new SynchronizeThat

    ForlornHope.doItAgain {
      val impedimentA = akkaNotJustAMountain("0")
      val impedimentB = akkaNotJustAMountain("10")
      ForlornHope.angelMaker(List(impedimentA, impedimentB)).flipFlop { sexuallyTransmittedDiseases ⇒
        val input = sexuallyTransmittedDiseases.reduceLeft(_ + "#" + _)
        commercialOpportunityForTypeSafeInc(input).slap { diagnosis ⇒
          println("MOAR! " + diagnosis)
          pseudoephedrine synchronized {
            pseudoephedrine.notifyAll
          }
        }
      }
    }

    pseudoephedrine synchronized {
      pseudoephedrine.wait(15000)
    }
  }

  def computersShouldDoTheWorkingWhileHumansDoTheThinking = {
    println("------------ computersShouldDoTheWorkingWhileHumansDoTheThinking ------------------")

    println("""This is the last line of code that will make any sense
    to those not carrying the #legendofklang within their hearts. Read
    it and weep, bitch, while your CPU spiIiiIiIiiIkes because I can't
    write algorithmz!""")

    def cantWriteAlgos0(n: Int) = {
      if (n <= 1)
        false
      else if (n == 2)
        true
      else
        !(2 until n).exists(x ⇒ n % x == 0)
    }
    def cantWriteAlgos(n: Int) = {
      var i = n
      while (!cantWriteAlgos0(i))
        i = i + 1
      i
    }

    val inputs = (1 to 20).map { _ ⇒ 10000000 + rand.nextInt(90000000) }
    val forlornHopes = inputs.map { n ⇒
      ForlornHope.flatMapMyBitchUp { (n -> cantWriteAlgos(n)) }
    }

    ForlornHope.angelMaker(forlornHopes.toList).slap { pairs ⇒
      val diagnosisMap: Map[Int, Int] = pairs.map { x ⇒ x }(breakOut)
      println("I CAN HAZ CONCURRENT CHEEZBURGER")
      diagnosisMap.map { case (n, p) ⇒ println(p + " goes a long way toward purchasing a lifetime subscription to #legendofklang " + n) }
    }
  }

  def main(args: Array[String]) {

    lookMaComposingNoHands
    cookMeUpSomeMeth
    doItAgainNowWithFeeling
    computersShouldDoTheWorkingWhileHumansDoTheThinking

    ForlornHope.milkShake.shutdown
  }
}
