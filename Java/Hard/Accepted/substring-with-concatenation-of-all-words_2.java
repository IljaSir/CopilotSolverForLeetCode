class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        int n = s.length();
        int m = words.length;
        int k = words[0].length();
        if (n < m * k) {
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i < k; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int left = i, right = i, count = 0;
            while (right + k <= n) {
                String w = s.substring(right, right + k);
                right += k;
                if (!map.containsKey(w)) {
                    seen.clear();
                    count = 0;
                    left = right;
                } else {
                    seen.put(w, seen.getOrDefault(w, 0) + 1);
                    count++;
                    while (seen.get(w) > map.get(w)) {
                        String w2 = s.substring(left, left + k);
                        seen.put(w2, seen.get(w2) - 1);
                        count--;
                        left += k;
                    }
                    if (count == m) {
                        res.add(left);
                        String w2 = s.substring(left, left + k);
                        seen.put(w2, seen.get(w2) - 1);
                        count--;
                        left += k;
                    }
                }
            }
        }
        return res;
    }
}