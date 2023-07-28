class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        
        int count = 0;
        for (int i = 0; i < targetWords.length; i++) {
            for (int j = 0; j < startWords.length; j++) {
                if (startWords[j].length() == targetWords[i].length()) {
                    if (isPermutation(startWords[j], targetWords[i])) {
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }
    public boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            arr1[str1.charAt(i) - 'a']++;
            arr2[str2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}