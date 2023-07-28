class Solution {
    public boolean equalFrequency(String word) {
        
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                map.put(freq[i], map.getOrDefault(freq[i], 0) + 1);
            }
        }
        if (map.size() == 1) {
            return true;
        }
        if (map.size() == 2) {
            Map.Entry<Integer, Integer> first = map.firstEntry();
            Map.Entry<Integer, Integer> last = map.lastEntry();
            if (first.getValue() == 1 && first.getKey() == 1) {
                return true;
            }
            if (last.getValue() == 1 && last.getKey() - first.getKey() == 1) {
                return true;
            }
        }
        return false;
    }
}