class Notifier {
    private List<String> messages = []
    def getMessages(){
        return messages
    }
    def notify(String message){
        messages.add(message)
    }
}
