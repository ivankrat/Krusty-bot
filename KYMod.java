import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.awt.Color;
import java.util.List;
import net.dv8tion.jda.core.EmbedBuilder;

public class KYMod extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getAuthor().isBot()) {
			return;
		}
		
		Message message = event.getMessage();
		String[] content = message.getContentRaw().split(" ");
		MessageChannel channel = event.getChannel();
		EmbedBuilder eb = new EmbedBuilder();
		
		Role role = event.getMember().getRoles().get(0);
		if(content[0].startsWith("KYMstats") && role.getName().equals("Discord Manager")) {
			if(content[1].equals("guild")) {
				eb.setColor(Color.RED);
				eb.setTitle("Guild Info:");
				eb.addField("name:", "" + event.getGuild().getName(), false);
				eb.addField("ID:", "" + event.getGuild().getId(), false);
				eb.addField("iconID:", "" + event.getGuild().getIconId(), false);
				eb.addField("splashID:", "" + event.getGuild().getSplashId(), false);
				eb.addField("regionRaw:", "" + event.getGuild().getRegionRaw(), false);
				channel.sendMessage(eb.build()).queue();
			}
			
			if(content[1].equals("channel")) {
				if(content.length == 2 ) {
					eb.setColor(Color.RED);
					eb.setTitle("Channel Info:");
					eb.addField("name:", "" + event.getChannel().getName(), false);
					eb.addField("ID:", "" + event.getChannel().getId(), false);
					eb.addField("guildID:", "" + event.getGuild().getId(), false);
					eb.addField("type:", "" + event.getChannelType().toString(), false);
					eb.addField("latestMessageID:", "" + event.getChannel().getLatestMessageId(), false);
					channel.sendMessage(eb.build()).queue();
				}
				else {
					Channel channelRequested = event.getGuild().getTextChannelsByName(content[2], false).get(0);
					if(content[2].equals(channelRequested.getName())) {
						eb.setColor(Color.RED);
						eb.setTitle("Channel Info:");
						eb.addField("name:", "" + channelRequested.getName(), false);
						eb.addField("ID:", "" + channelRequested.getId(), false);
						eb.addField("guildID:", "" + event.getGuild().getId(), false);
						eb.addField("type:", "" + channelRequested.getType().toString(), false);
						eb.addField("latestMessageID:", "" + ((MessageChannel) channelRequested).getLatestMessageId(), false);
						channel.sendMessage(eb.build()).queue();
					}
					else {
						eb.setColor(Color.RED);
						eb.addField("ERROR:", "null", false);
						channel.sendMessage(eb.build()).queue();
					}
				}
			}
			
			if(content[1].equals("user")) {
				if(content.length == 2 ) {
					eb.setColor(Color.RED);
					eb.setTitle("User Info:");
					eb.addField("name:", "" + event.getAuthor().getName(), false);
					eb.addField("nickName:", "" + event.getMember().getNickname(), false);
					eb.addField("ID:", "" + event.getAuthor().getId(), false);
					eb.addField("status:", "" + event.getMember().getOnlineStatus(), false);
					eb.addField("owner:", "" + event.getMember().isOwner(), false);
					eb.addField("role:", "" + event.getMember().getRoles(), false);
					eb.addField("permissions:", "" + event.getMember().getPermissions(), false);
					channel.sendMessage(eb.build()).queue();
				}
				else {
					String fullName = allUserName(content);
					if(isUser(event, fullName)) {
						User user = event.getGuild().getMembersByName(fullName, false).get(0).getUser();
						Member member = event.getGuild().getMembersByName(fullName, false).get(0);
						eb.setColor(Color.RED);
						eb.setTitle("User Info:");
						eb.addField("name:", "" + user.getName(), false);
						eb.addField("nickName:", "" + member.getNickname(), false);
						eb.addField("ID:", "" + user.getId(), false);
						eb.addField("status:", "" + member.getOnlineStatus(), false);
						eb.addField("owner:", "" + member.isOwner(), false);
						eb.addField("role:", "" + member.getRoles(), false);
						eb.addField("permissions:", "" + member.getPermissions(), false);
						channel.sendMessage(eb.build()).queue();
					}
					else if(isUserNick(event, fullName)) {
						User userNick = event.getGuild().getMembersByNickname(fullName, false).get(0).getUser();
						Member memberNick = event.getGuild().getMembersByNickname(fullName, false).get(0);
						eb.setColor(Color.RED);
						eb.setTitle("User Info:");
						eb.addField("name:", "" + userNick.getName(), false);
						eb.addField("nickName:", "" + memberNick.getNickname(), false);
						eb.addField("ID:", "" + userNick.getId(), false);
						eb.addField("status:", "" + memberNick.getOnlineStatus(), false);
						eb.addField("owner:", "" + memberNick.isOwner(), false);
						eb.addField("role:", "" + memberNick.getRoles(), false);
						eb.addField("permissions:", "" + memberNick.getPermissions(), false);
						channel.sendMessage(eb.build()).queue();
					}
					else {
						eb.setColor(Color.RED);
						eb.addField("ERROR:", "null", false);
						channel.sendMessage(eb.build()).queue();
					}
				}
			}
		}
		else if(content[0].startsWith("KYMstats")) {
			eb.setColor(Color.RED);
			eb.addField("ACCESS DENIED:", "incorrect String - |snowFlakeID", false);
			channel.sendMessage(eb.build()).queue();
		}
	}
	
	private boolean isUser(MessageReceivedEvent event, String name) {
		boolean user = false;
		List<Member> members = event.getGuild().getMembers();
		
		for(int i = 0; i < members.size(); i++) {
			if(name.equals(members.get(i).getUser().getName())) {
				user = true;
			}
		}
		
		return user;
	}
	
	private boolean isUserNick(MessageReceivedEvent event, String name) {
		boolean user = false;
		List<Member> members = event.getGuild().getMembers();
		
		for(int i = 0; i < members.size(); i++) {
			if(name.equals(members.get(i).getNickname())) {
				user = true;
			}
		}
		
		return user;
	}
	
	private String allUserName(String[] nameList) {
		String name = "";
		
		for(int i = 2; i < nameList.length; i++) {
			name += nameList[i] + " ";
		}
		
		name = name.substring(0, name.length() - 1);
		return name;
	}
}
