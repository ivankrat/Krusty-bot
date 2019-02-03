
public class Random {
	public static String[] randomStuff = {"*Krusty sneezes* ahw how cute","*Krusty sneezes* ahw how cute",
			"*Krusty brutally murdered a fly*\\n...he might be spending too much time with Gnort*","*Krusty dose a barrel role*",
			"*Krusty dose a barrel role*","*Krusty tries to swim in a pound,\nhe sinks to the bottom*","*Krusty purrs*","*Krusty purrs*",};
	
	public static String getRandom() {
		return randomStuff[(int)(randomStuff.length * Math.random())];
	}
}
