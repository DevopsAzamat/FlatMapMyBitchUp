import sbt._
import util.DynamicVariable

import com.github.olim7t.sbtscalariform._


class FlatMapMyBitchProject(info: ProjectInfo) extends DefaultProject(info) with ScalariformPlugin {
  // Tack, Jonas, fĂ¶r denna konfiguration. Dessa nya pilar Ă¤r
  // fantastiska.
  override def scalariformOptions = Seq(
    //VerboseScalariform,
    AlignParameters(true),
    CompactStringConcatenation(false),
    IndentPackageBlocks(true),
    FormatXml(true),
    PreserveSpaceBeforeArguments(false),
    DoubleIndentClassDeclaration(false),
    RewriteArrowSymbols(true),
    AlignSingleLineCaseStatements(true),
    SpaceBeforeColon(false),
    PreserveDanglingCloseParenthesis(false),
    IndentSpaces(2),
    IndentLocalDefs(false)
    //      MaxArrowIndent(40),
    //      SpaceInsideBrackets(false),
    //      SpaceInsideParentheses(false),
    //SpacesWithinPatternBinders(true)
  )
  lazy val demo = task {
    runTask(Some("FlatMapMyBitchUpDemo"), runClasspath).run
  }.dependsOn(compile)
}
