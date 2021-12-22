package endeavor.nabi.commands.moderation

import com.kotlindiscord.kord.extensions.extensions.Extension
import com.kotlindiscord.kord.extensions.extensions.chatCommand
import dev.kord.core.Kord
import dev.kord.x.emoji.Emojis
import dev.kord.x.emoji.toReaction
import org.koin.core.component.inject
import utils.Extensions.isOwner

class Reboot : Extension() {

    private val kordClient: Kord by inject()

    override val name: String
        get() = "reboot"

    override suspend fun setup() {
        chatCommand {
            name = "reboot"
            description = "The bot will proceed to reboot. In this process, all functions will be nulled, and won't register. **THIS IS A DANGEROUS COMMAND, SO ONLY THE OWNER WILL HAVE ACCESS**"
            action {
                if (message.author?.id?.isOwner()?.not() != false) {
                    message.author.createMessage("You cannot execute said command due to it being an owner only command.")
                } else {
                    message.addReaction(Emojis.wave.toReaction())
                    message.channel
                }
            }
        }
    }
}