class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String[] words = messages[i].split(" ");
            map.put(senders[i], map.getOrDefault(senders[i], 0) + words.length);
        }
        int max = 0;
        String ans = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans = entry.getKey();
            } else if (entry.getValue() == max) {
                ans = ans.compareTo(entry.getKey()) < 0 ? ans : entry.getKey();
            }
        }
        return ans;
    }
}