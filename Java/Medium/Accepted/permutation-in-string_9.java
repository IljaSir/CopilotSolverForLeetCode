class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] s1arr = new int[26];
        for(char c : s1.toCharArray()){
            s1arr[c - 'a']++;
        }
        int[] s2arr = new int[26];
        int left = 0;
        int right = 0;
        while(right < s2.length()){
            s2arr[s2.charAt(right) - 'a']++;
            if(right - left + 1 > s1.length()){
                s2arr[s2.charAt(left) - 'a']--;
                left++;
            }
            if(right - left + 1 == s1.length() && Arrays.equals(s1arr, s2arr)){
                return true;
            }
            right++;
        }
        return false;
    }
}