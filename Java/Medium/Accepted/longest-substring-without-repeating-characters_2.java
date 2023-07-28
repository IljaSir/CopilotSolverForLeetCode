class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                // If the map contains the character, then we need to move the left pointer to the right of the current value of the right pointer
                // This is to ensure that the characters in between are not repeated
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}