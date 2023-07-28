class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        int n = words.length;
        int[] lens = new int[n];
        for (int i = 0; i < n; i++) {
            lens[i] = words[i].length();
        }
        Arrays.sort(lens);
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            int len = lens[i];
            if (i == n - 1 || lens[i + 1] != len) {
                ans += len + 1;
            } else {
                i--;
            }
        }
        return ans;
    }
}