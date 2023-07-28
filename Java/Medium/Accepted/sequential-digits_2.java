class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> res = new ArrayList<>();
        int lowLen = Integer.toString(low).length();
        int highLen = Integer.toString(high).length();
        for (int len = lowLen; len <= highLen; len++) {
            for (int i = 1; i <= 10 - len; i++) {
                int val = 0;
                for (int j = 0; j < len; j++) {
                    val = val * 10 + i + j;
                }
                if (val >= low && val <= high) {
                    res.add(val);
                }
            }
        }
        return res;
    }
}