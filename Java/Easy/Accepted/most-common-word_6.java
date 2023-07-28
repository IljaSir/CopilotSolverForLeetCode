class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[^a-z]", " ");
        String[] words = paragraph.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!word.equals("")) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        for (String ban : banned) {
            map.remove(ban);
        }
        String res = "";
        int max = 0;
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                res = key;
            }
        }
        return res;
    }
}