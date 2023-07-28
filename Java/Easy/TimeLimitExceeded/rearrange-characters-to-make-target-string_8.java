class Solution {
    public int rearrangeCharacters(String s, String target) {
        
        if (s.length() < target.length()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max(max, map.get(c));
        }
        if (max > (s.length() + 1) / 2) {
            return 0;
        }
        int[] count = new int[26];
        for (char c : target.toCharArray()) {
            count[c - 'a']++;
        }
        int res = 0;
        while (true) {
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    if (map.get((char)('a' + i)) == null || map.get((char)('a' + i)) == 0) {
                        return res;
                    }
                    map.put((char)('a' + i), map.get((char)('a' + i)) - 1);
                    count[i]--;
                }
            }
            res++;
        }
    }
}