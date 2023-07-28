class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> res = new ArrayList<>();
        if (s == null || words == null || words.length == 0) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int len = words[0].length();
        int n = words.length;
        for (int i = 0; i < len; i++) {
            Map<String, Integer> tmp = new HashMap<>();
            int left = i, right = i, count = 0;
            while (right + len <= s.length()) {
                String str = s.substring(right, right + len);
                right += len;
                if (map.containsKey(str)) {
                    tmp.put(str, tmp.getOrDefault(str, 0) + 1);
                    count++;
                    while (tmp.get(str) > map.get(str)) {
                        String leftStr = s.substring(left, left + len);
                        left += len;
                        tmp.put(leftStr, tmp.get(leftStr) - 1);
                        count--;
                    }
                    if (count == n) {
                        res.add(left);
                    }
                } else {
                    tmp.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return res;
    }
}