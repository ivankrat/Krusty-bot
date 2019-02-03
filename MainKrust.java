import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class MainKrust {
	public static void main(String[] args) throws Exception{
		try {
			JDA api = new JDABuilder(AccountType.BOT).setToken("NTI1ODA4OTIzMDE4Nzg4ODY0.Dv89jg.9nvsgxJkn7uqey3M8vZ9U1JZPn8").buildAsync();
			api.addEventListener(new KYFun());
			api.addEventListener(new KYMod());
			api.addEventListener(new KYStats());
			api.addEventListener(new KYPlayerTracker());
//			api.addEventListener(new KYFilter());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
