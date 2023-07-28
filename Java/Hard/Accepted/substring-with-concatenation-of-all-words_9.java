class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        // 1. Create a map of the words
        // 2. Iterate through the string and check if the substring is in the map
        // 3. If it is, then add the index to the list
        // 4. If it is not, then continue
        // 5. Return the list
        
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        int length = s.length();
        
        for (int i = 0; i < length - totalLength + 1; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; j < words.length; j++) {
                int start = i + j * wordLength;
                String word = s.substring(start, start + wordLength);
                if (copy.containsKey(word)) {
                    int count = copy.get(word);
                    if (count == 1) {
                        copy.remove(word);
                    } else {
                        copy.put(word, count - 1);
                    }
                } else {
                    break;
                }
            }
            
            if (copy.isEmpty()) {
                result.add(i);
            }
        }
        
        return result;
    }
}