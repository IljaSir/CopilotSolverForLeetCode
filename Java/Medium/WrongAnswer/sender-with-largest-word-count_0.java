class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            map.put(senders[i], map.getOrDefault(senders[i], 0) + messages[i].split(" ").length);
        }
        int max = 0;
        String maxSender = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxSender = entry.getKey();
            } else if (entry.getValue() == max) {
                maxSender = maxSender.compareTo(entry.getKey()) > 0 ? entry.getKey() : maxSender;
            }
        }
        return maxSender;
    }
}