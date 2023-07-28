class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < messages.length; i++) {
            String[] words = messages[i].split(" ");
            map.put(senders[i], map.getOrDefault(senders[i], 0) + words.length);
        }
        String res = "";
        int max = 0;
        for(String key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                res = key;
            } else if(map.get(key) == max) {
                if(key.compareTo(res) > 0) {
                    res = key;
                }
            }
        }
        return res;
    }
}