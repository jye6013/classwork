package chatbot;

public class Chatbot {
	
	private String username;
	private boolean chatting;
	private Topic ji;

	public Chatbot() {
		ji = new ChatbotJi();
		username = "Unknown User";
		chatting = true;
	}

	public void startChatting() {
		//whenever you print or get input, use these methods
		ChatbotMain.print("Hi! I am intelligent machine that can respond to your input. Tell me your name.");
		username = ChatbotMain.getInput();
		while(chatting) {
			ChatbotMain.print("What would you like to talk about?");
			String response = ChatbotMain.getInput();
			if(ji.isTriggered(response)) {
				chatting = false;//exit the while loop. IMPORTANT you get graded for this!
				ji.talk(response);
			}else {
				ChatbotMain.print("I'm sorry. I don't understand. I never said I was perfect.");
			}
		}
	}

}
