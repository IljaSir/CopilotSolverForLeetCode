class Solution {
    public int maxLength(List<String> arr) {
        
        List<Integer> masks = new ArrayList<Integer>();
        masks.add(0);
        int ret = 0;
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
            if (mask == 0) {
                continue;
            }
            for (int i = masks.size() - 1; i >= 0; i--) {
                int m = masks.get(i);
                if ((m & mask) == 0) {
                    masks.add(m | mask);
                    ret = Math.max(ret, Integer.bitCount(m | mask));
                }
            }
        }
        return ret;
    }
}