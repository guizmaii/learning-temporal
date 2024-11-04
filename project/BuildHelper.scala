import com.typesafe.sbt.packager.universal.UniversalPlugin.autoImport.Universal
import org.typelevel.scalacoptions.ScalacOptions
import sbt.*
import sbt.Keys.*

object BuildHelper {

  private val javaTarget = "21"

  def env(v: String): Option[String] = sys.env.get(v)
  def unsafeEnv(v: String): String   = sys.env(v)

  lazy val stdSettings =
    noDoc ++ Seq(
      javacOptions ++= Seq("-source", javaTarget, "-target", javaTarget),
      scalacOptions ++= Seq("-no-indent"), // See https://x.com/ghostdogpr/status/1706589471469425074
      scalacOptions ++= Seq(s"-release:$javaTarget"),
      scalacOptions --= (if (insideCI.value) Nil else Seq("-Xfatal-warnings")),
      // format: off
    )

  lazy val noDoc = Seq(
    (Compile / doc / sources)                := Seq.empty,
    (Compile / packageDoc / publishArtifact) := false,
  )

}
