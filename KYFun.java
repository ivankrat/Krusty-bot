import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import java.awt.Color;
import net.dv8tion.jda.core.EmbedBuilder;


public class KYFun extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent event) {
		if(event.getAuthor().isBot()) {
			return;
		}
		
		Message message = event.getMessage();
		String[] content = message.getContentRaw().split(" ");
		MessageChannel channel = event.getChannel();
		EmbedBuilder eb = new EmbedBuilder();
		
		if(content[0].equals("KYcool")) {
			eb.setColor(Color.GREEN);
			eb.setImage("https://3.bp.blogspot.com/-_V20HLNgir8/T18QU97lpyI/AAAAAAAAALg/6B9YIptR9XQ/s1600/animated-pet-rock.gif");
			eb.addField("Fun Time!!!", "*Krusty puts on shades*", false);
			channel.sendMessage(eb.build()).queue();
		}
		
		if(content[0].equals("KYdab")) {
			eb.setColor(Color.GREEN);
			eb.setImage("https://thumbs.gfycat.com/MediumThoughtfulFinwhale-size_restricted.gif");
			eb.addField("Fun Time!!!", "*Krusty dabs*", false);
			channel.sendMessage(eb.build()).queue();
		}
		
		if(content[0].equals("KYdance")) {
			eb.setColor(Color.GREEN);
			eb.setImage("https://i.gifer.com/Sc5.gif");
			eb.addField("Fun Time!!!", "*Krusty gets down*", false);
			channel.sendMessage(eb.build()).queue();
		}
		
		if(content[0].equals("KYnap")) {
			eb.setColor(Color.GREEN);
			eb.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMqQZ51QcJj5OUoVWS8za9MvXHmh-VCJiMPfhWn9r1Qwewl1HIdw");
			eb.addField("Fun Time!!!", "*Krusty nuzzles Krust's neck and falls asleep on his shoulder*", false);
			channel.sendMessage(eb.build()).queue();
		}
		
		if(content[0].equals("KYrandom")) {
			eb.setColor(Color.GREEN);
			eb.addField("Fun Time!!!", Random.getRandom(), false);
			channel.sendMessage(eb.build()).queue();
		}
		
		if(content[0].equals("KYspook")) {
			eb.setColor(Color.GREEN);
			eb.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQk8Q2Nw6cxf5w_GQBWJHRJtFCHYFSHVM5Qi2O_wOAeQ1p4i4QECA");
			eb.addField("Fun Time!!!", "*Krusty stares at Kazy*", false);
			channel.sendMessage(eb.build()).queue();
		}
		
		if(content[0].equals("KYwalk")) {
			eb.setColor(Color.GREEN);
			eb.setImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTx48lDkirnvXy0cWwZ_Vc4YQKqY88Cl5Sfy3o6msSVHC5nbGrS");
			eb.addField("Fun Time!!!", "*You take Krusty for a walk*", false);
			channel.sendMessage(eb.build()).queue();
		}
		
		if(content[0].equals("KYwobble")) {
			eb.setColor(Color.GREEN);
			eb.setImage("https://media.giphy.com/media/7pqpo2BWeJuxi/giphy.gif");
			eb.addField("Fun Time!!!", "*Krusty wobbles*", false);
			channel.sendMessage(eb.build()).queue();
		}
	}
}
