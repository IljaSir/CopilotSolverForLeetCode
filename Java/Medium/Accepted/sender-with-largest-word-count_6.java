class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < messages.length; i++) {
            String[] words = messages[i].split(" ");
            if (map.containsKey(senders[i])) {
                map.put(senders[i], map.get(senders[i]) + words.length);
            } else {
                map.put(senders[i], words.length);
            }
        }
        int max = 0;
        String res = "";
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                res = key;
            } else if (map.get(key) == max) {
                if (key.compareTo(res) > 0) {
                    res = key;
                }
            }
        }
        return res;
    }
}