class Solution {
    public boolean areOccurrencesEqual(String s) {
        
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                if (count == 0) {
                    count = arr[i];
                } else if (count != arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
}