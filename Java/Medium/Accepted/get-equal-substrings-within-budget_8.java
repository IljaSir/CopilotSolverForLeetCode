class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        int n = s.length(), l = 0, r = 0, cost = 0;
        while (r < n) {
            cost += Math.abs(s.charAt(r) - t.charAt(r++));
            if (cost > maxCost)
                cost -= Math.abs(s.charAt(l) - t.charAt(l++));
        }
        return r - l;
    }
}