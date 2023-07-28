class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) {
            return res;
        }
        int wordLen = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < s.length() - wordLen * words.length + 1; i++) {
            Map<String, Integer> copy = new HashMap<>(map);
            for (int j = 0; j < words.length; j++) {
                String sub = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (copy.containsKey(sub)) {
                    int count = copy.get(sub);
                    if (count == 1) {
                        copy.remove(sub);
                    } else {
                        copy.put(sub, count - 1);
                    }
                    if (copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return res;
    }
}