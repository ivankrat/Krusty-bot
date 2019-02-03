import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;

public class KYFilter extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent event) {
		String[] content = {"beesechurger", "beese", "churger"};
		String[] noNoWords = event.getMessage().getContentRaw().split(" ");
		MessageChannel channel = event.getChannel();
		EmbedBuilder eb = new EmbedBuilder();
		
		for(int i = 0; i < content.length; i++) {
			for(int j = 0; j < noNoWords.length; j++) {
				if(content[i].equalsIgnoreCase(noNoWords[0])) {
					event.getMessage().delete().complete();
					eb.setColor(Color.BLACK);
					eb.addField("Ivan has a message for you:", "FUCK OFF AEDYN", false);
					channel.sendMessage(eb.build()).queue();
				}
			}
		}
	}
}
