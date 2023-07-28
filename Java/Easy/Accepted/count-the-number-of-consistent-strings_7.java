class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        
        int count = 0;
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (!allowed.contains(word.charAt(i) + "")) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }
}