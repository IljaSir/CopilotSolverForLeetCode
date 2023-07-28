class Solution {
    public int[] sumPrefixScores(String[] words) {
        
        int[] res = new int[words.length];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
                res[i] += map.get(c);
            }
            map.clear();
        }
        return res;
    }
}