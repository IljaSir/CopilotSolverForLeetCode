class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - totalLength + 1; i++) {
            int j = i;
            Map<String, Integer> tempMap = new HashMap<>();
            while (j < i + totalLength) {
                String word = s.substring(j, j + wordLength);
                if (!map.containsKey(word)) {
                    break;
                }
                tempMap.put(word, tempMap.getOrDefault(word, 0) + 1);
                if (tempMap.get(word) > map.get(word)) {
                    break;
                }
                j += wordLength;
            }
            if (j == i + totalLength) {
                result.add(i);
            }
        }
        return result;
    }
}