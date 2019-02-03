import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;

public class KYStats extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getAuthor().isBot()) {
			return;
		}
		
		Message message = event.getMessage();
		String[] content = message.getContentRaw().split(" ");
		MessageChannel channel = event.getChannel();
		EmbedBuilder eb = new EmbedBuilder();
		
		if(content[0].startsWith("KYhelp")) {
			eb.setColor(Color.WHITE);
			eb.setTitle("Help Page:");
			eb.addField("Info:", "KYhelp\nKYstats (name) - character info", false);
			eb.addField("Fun:", "KYcool\nKYdab\nKYdance\nKYnap\nKYspook\nKYwalk\nKYwobble", false);
			eb.addField("Mod:", "KYMstats guild - server info\nKYMstats channel (optional:channelName) - channel info\nKYMstats user (optional:userName/nickName) - user info", false);
			channel.sendMessage(eb.build()).queue();
		}
		
		//TODO) create pdf / txt file and save and read player stats
	}
}
