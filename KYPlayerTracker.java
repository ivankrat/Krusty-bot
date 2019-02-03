import java.awt.Color;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class KYPlayerTracker extends ListenerAdapter {
	//TODO) get online status and print to main channel and Krusty
	public void onUserUpdateOnlineStatusReceived(UserUpdateOnlineStatusEvent event) {
		if(event.getUser().isBot()) {
			return;
		}
			
		OnlineStatus status = event.getMember().getOnlineStatus();
		OnlineStatus online = OnlineStatus.ONLINE;
		OnlineStatus idle = OnlineStatus.IDLE;
		OnlineStatus doNotDisturb = OnlineStatus.DO_NOT_DISTURB;
		OnlineStatus invisible = OnlineStatus.INVISIBLE;
		MessageChannel channelKrusty = event.getGuild().getTextChannelsByName("krusty", false).get(0);
		EmbedBuilder eb = new EmbedBuilder();
		
		if(status.equals(OnlineStatus.ONLINE)) {
			eb.setColor(Color.GREEN);
			eb.addField("HELLO!!!", "*Krusty wobbles at you*\nyou get the feeling he is trying to say hi*", false);
			channelKrusty.sendMessage(eb.build()).queue();
		}
	}
}
