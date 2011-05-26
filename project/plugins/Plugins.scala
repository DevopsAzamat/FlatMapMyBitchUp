import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) {
  val scalariform = "com.github.olim7t" % "sbt-scalariform" % "1.0.3"
}
