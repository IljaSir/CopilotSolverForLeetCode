class Solution {
    public String longestDupSubstring(String s) {
        
        int n = s.length();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = (int)s.charAt(i) - (int)'a';
        }
        int a = 26;
        long modulus = (long)Math.pow(2, 32);
        int left = 1, right = n;
        int l = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(search(mid, a, modulus, n, nums) != -1) {
                l = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int start = search(l, a, modulus, n, nums);
        return s.substring(start, start + l);
    }
    
    private int search(int l, int a, long modulus, int n, int[] nums) {
        long h = 0;
        for(int i = 0; i < l; i++) {
            h = (h * a + nums[i]) % modulus;
        }
        HashSet<Long> seen = new HashSet();
        seen.add(h);
        long aL = 1;
        for(int i = 1; i <= l; i++) {
            aL = (aL * a) % modulus;
        }
        for(int start = 1; start < n - l + 1; start++) {
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + l - 1]) % modulus;
            if(seen.contains(h)) {
                return start;
            }
            seen.add(h);
        }
        return -1;
    }
}