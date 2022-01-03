package endeavor.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.check.anyGuild
import com.kotlindiscord.kord.extensions.check.hasPermission
import com.kotlindiscord.kord.extensions.check.hasPermissions

class Ban : Extension() {
    override val name = "ban"

    override suspend fun setup() {

    }
}