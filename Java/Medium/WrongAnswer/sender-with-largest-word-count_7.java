class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String[] words = messages[i].split(" ");
            int count = map.getOrDefault(senders[i], 0);
            map.put(senders[i], count + words.length);
        }
        String sender = "";
        int max = 0;
        for (String s : map.keySet()) {
            if (map.get(s) > max) {
                max = map.get(s);
                sender = s;
            } else if (map.get(s) == max) {
                sender = sender.compareTo(s) > 0 ? s : sender;
            }
        }
        return sender;
    }
}