class Solution {
    public String nearestPalindromic(String n) {
        
        long num = Long.parseLong(n);
        long minDiff = Long.MAX_VALUE;
        long candidate = 0;
        for (long cand : candidates(n)) {
            if (cand == num) continue;
            if (Math.abs(num - cand) < minDiff) {
                minDiff = Math.abs(num - cand);
                candidate = cand;
            } else if (Math.abs(num - cand) == minDiff) {
                candidate = Math.min(candidate, cand);
            }
        }
        return String.valueOf(candidate);
    }
    
    private List<Long> candidates(String n) {
        List<Long> res = new ArrayList<>();
        res.add((long)Math.pow(10, n.length()) + 1);
        res.add((long)Math.pow(10, n.length() - 1) - 1);
        
        String left = n.substring(0, (n.length() + 1) / 2);
        String right = n.substring(0, n.length() / 2);
        for (int i = -1; i <= 1; i++) {
            String s = String.valueOf(Long.parseLong(left) + i);
            res.add(Long.parseLong(s + new StringBuilder(s).reverse().toString()));
            res.add(Long.parseLong(s + new StringBuilder(s.substring(0, s.length() - (n.length() % 2))).reverse().toString()));
        }
        return res;
    }
}