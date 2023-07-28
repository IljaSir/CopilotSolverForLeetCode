class Solution {
    public int[] groupStrings(String[] words) {
        
        int[] result = new int[2];
        if (words.length == 0) return result;
        if (words.length == 1) {
            result[0] = 1;
            result[1] = 1;
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            String key = getKey(word);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(word);
            map.put(key, list);
        }
        int max = 0;
        int maxLen = 0;
        for (String key : map.keySet()) {
            int size = map.get(key).size();
            if (size > maxLen) {
                maxLen = size;
            }
            max++;
        }
        result[0] = max;
        result[1] = maxLen;
        return result;
    }
    
    private String getKey(String word) {
        if (word.length() == 1) return "0";
        int diff = word.charAt(1) - word.charAt(0);
        if (diff < 0) diff += 26;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < word.length(); i++) {
            int d = word.charAt(i) - word.charAt(i - 1);
            if (d < 0) d += 26;
            sb.append(d - diff);
        }
        return sb.toString();
    }
}