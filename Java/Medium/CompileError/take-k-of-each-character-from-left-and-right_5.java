class Solution {
    public int takeCharacters(String s, int k) {
        
        int left = 0, right = s.length() - 1;
        int count = 0;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                left = 0;
                right--;
                count++;
            }
        }
        return count;
    }
    public int longestSubsequence(String s, int k) {
        int len = s.length();
        if (len < k) {
            return -1;
        }
        if (k == 1) {
            return 1;
        }
        int result = 0;
        int count = 0;
        int left = 0, right = len - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                left = 0;
                right--;
                count++;
            }
        }
        return count; + 1);
            }
        }
        return res;
    }
}