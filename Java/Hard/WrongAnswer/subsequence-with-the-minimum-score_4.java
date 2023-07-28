class Solution {
    public int minimumScore(String s, String t) {
        
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            arr[c - 'a']--;
        }
        int left = 0;
        int right = 0;
        int result = 0;
        for (int i = 0; i < 26; i++) {
            while (arr[i] < 0) {
                result += right - left + 1;
                arr[i]++;
                left++;
                right++;
            }
            right++;
        }
        return result;
    }
}