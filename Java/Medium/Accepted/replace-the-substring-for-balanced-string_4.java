class Solution {
    public int balancedString(String s) {
        
        int n = s.length();
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'A']++;
        }
        int k = n / 4;
        if (count['Q' - 'A'] == k && count['W' - 'A'] == k && count['E' - 'A'] == k && count['R' - 'A'] == k) {
            return 0;
        }
        int ans = n;
        int left = 0;
        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'A']--;
            while (left < n && count['Q' - 'A'] <= k && count['W' - 'A'] <= k && count['E' - 'A'] <= k && count['R' - 'A'] <= k) {
                ans = Math.min(ans, right - left + 1);
                count[s.charAt(left) - 'A']++;
                left++;
            }
        }
        return ans;
    }
}