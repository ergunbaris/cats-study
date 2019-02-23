lazy val commonSettings = Seq(
  name         := "simulacrum_test",
  organization := "pairwiseltd",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.11.8",
  mainClass in  (Compile, run) := Some("com.pairwiseltd.simulacrum.trial.SemiGroupTrial")
)

lazy val root = (project in file("."))
  .settings(
    commonSettings,        
    libraryDependencies += "com.github.mpilquist" %% "simulacrum" % "0.15.0",
    libraryDependencies ++= {
      CrossVersion.partialVersion(scalaVersion.value) match {
        case Some((2, v)) if v <= 12 =>
          Seq(
            compilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
          )
        case _ =>
          // if scala 2.13.0-M4 or later, macro annotations merged into scala-reflect
          // https://github.com/scala/scala/pull/6606
          Nil
      }
    }

  )

