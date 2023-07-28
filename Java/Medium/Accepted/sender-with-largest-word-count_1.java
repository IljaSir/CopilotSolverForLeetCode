class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String[] words = messages[i].split(" ");
            map.put(senders[i], map.getOrDefault(senders[i], 0) + words.length);
        }
        String res = "";
        int max = 0;
        for (String sender : map.keySet()) {
            if (map.get(sender) > max) {
                res = sender;
                max = map.get(sender);
            } else if (map.get(sender) == max) {
                res = sender.compareTo(res) > 0 ? sender : res;
            }
        }
        return res;
    }
}