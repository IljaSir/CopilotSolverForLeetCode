class Solution {
    public int rearrangeCharacters(String s, String target) {
        
        if (target.length() > s.length()) {
            return 0;
        }
        
        int[] count = new int[26];
        int[] targetCount = new int[26];
        int k = target.length();
        for (int i = 0; i < k; i++) {
            count[s.charAt(i) - 'a']++;
            targetCount[target.charAt(i) - 'a']++;
        }
        
        if (!canMake(count, targetCount)) {
            return 0;
        }
        
        int i = 0;
        while (i + k < s.length()) {
            count[s.charAt(i) - 'a']--;
            count[s.charAt(i + k) - 'a']++;
            if (!canMake(count, targetCount)) {
                return (i + k) / k;
            }
            i++;
        }
        return (i + k) / k;
    }
    
    private boolean canMake(int[] count, int[] targetCount) {
        int k = count.length;
        for (int i = 0; i < k; i++) {
            if (count[i] < targetCount[i]) {
                return false;
            }
        }
        return true;
    }
}