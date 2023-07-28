class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0; i < messages.length; i++){
            String[] words = messages[i].split(" ");
            int count = map.getOrDefault(senders[i],0);
            map.put(senders[i],count+words.length);
        }
        int max = 0;
        String sender = "";
        for(String s: map.keySet()){
            if(map.get(s) > max){
                max = map.get(s);
                sender = s;
            }else if(map.get(s) == max){
                if(s.compareTo(sender) > 0){
                    sender = s;
                }
            }
        }
        return sender;
    }
}