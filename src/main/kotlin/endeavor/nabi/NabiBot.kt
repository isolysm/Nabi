package endeavor.nabi

import com.github.jezza.Toml
import com.github.jezza.TomlTable
import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.modules.extra.phishing.DetectionAction
import com.kotlindiscord.kord.extensions.modules.extra.phishing.extPhishing
import dev.kord.common.entity.PresenceStatus
import mu.KotlinLogging
import org.kohsuke.github.GitHub
import org.kohsuke.github.GitHubBuilder
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.Exception

val 