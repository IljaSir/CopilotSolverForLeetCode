class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < messages.length; i++){
            String[] words = messages[i].split(" ");
            map.put(senders[i], map.getOrDefault(senders[i], 0) + words.length);
        }
        String res = "";
        for(String key: map.keySet()){
            if(map.get(key) > map.getOrDefault(res, 0)){
                res = key;
            }else if(map.get(key) == map.getOrDefault(res, 0)){
                if(key.compareTo(res) > 0){
                    res = key;
                }
            }
        }
        return res;
    }
}