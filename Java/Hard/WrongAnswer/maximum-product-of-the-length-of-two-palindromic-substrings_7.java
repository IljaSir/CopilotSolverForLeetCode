class Solution {
    public long maxProduct(String s) {
        
        int n = s.length();
        long ans = 0;
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    left.add(j);
                } else {
                    right.add(j);
                }
            }
            if (left.size() != right.size()) {
                continue;
            }
            int m = left.size();
            boolean valid = true;
            for (int j = 0; j < m / 2; j++) {
                if (s.charAt(left.get(j)) != s.charAt(left.get(m - j - 1))) {
                    valid = false;
                    break;
                }
            }
            for (int j = 0; j < m / 2; j++) {
                if (s.charAt(right.get(j)) != s.charAt(right.get(m - j - 1))) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                ans = Math.max(ans, (long) left.size() * right.size());
            }
        }
        return ans;
    }
}