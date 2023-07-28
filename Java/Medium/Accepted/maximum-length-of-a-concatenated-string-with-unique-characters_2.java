class Solution {
    public int maxLength(List<String> arr) {
        
        List<Integer> masks = new ArrayList();
        masks.add(0);
        int ans = 0;
        for (String s : arr) {
            int mask = 0;
            for (char c : s.toCharArray()) {
                int bit = c - 'a';
                if (((mask >> bit) & 1) != 0) {
                    mask = 0;
                    break;
                }
                mask |= 1 << bit;
            }
            if (mask == 0) continue;
            int n = masks.size();
            for (int i = 0; i < n; i++) {
                int m = masks.get(i);
                if ((m & mask) == 0) {
                    masks.add(m | mask);
                    ans = Math.max(ans, Integer.bitCount(m | mask));
                }
            }
        }
        return ans;
    }
}