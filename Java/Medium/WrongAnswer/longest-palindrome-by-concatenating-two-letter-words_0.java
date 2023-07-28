class Solution {
    public int longestPalindrome(String[] words) {
        
        Map<String, Integer> count = new HashMap();
        for (String w: words)
            count.put(w, count.getOrDefault(w, 0) + 1);

        int ans = 0;
        for (String w: count.keySet()) {
            int v = count.get(w);
            String r = new StringBuilder(w).reverse().toString();
            if (w.equals(r)) {
                ans += v / 2 * 2;
                if (v % 2 == 1 && ans % 2 == 0)
                    ans++;
            } else if (count.containsKey(r)) {
                ans += Math.min(v, count.get(r));
            }
        }
        return ans;
    }
}