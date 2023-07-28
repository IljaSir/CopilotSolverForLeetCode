class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        Set<String> set = new HashSet<>();
        for (String s : startWords) {
            set.add(s);
        }
        int result = 0;
        for (String s : targetWords) {
            if (set.contains(s)) {
                result++;
                continue;
            }
            boolean can = false;
            for (String start : startWords) {
                if (canAdd(start, s)) {
                    can = true;
                    break;
                }
            }
            if (can) {
                result++;
            }
        }
        return result;
    }

    private boolean canAdd(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if (len2 - len1 != 1) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < len2; i++) {
            char c = s2.charAt(i);
            count[c - 'a']--;
            if (count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}