class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            String[] words = messages[i].split(" ");
            map.put(senders[i], map.getOrDefault(senders[i], 0) + words.length);
        }
        String ans = "";
        int max = 0;
        for (String key: map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                ans = key;
            } else if (map.get(key) == max) {
                ans = ans.compareTo(key) < 0 ? ans : key;
            }
        }
        return ans;
    }
}