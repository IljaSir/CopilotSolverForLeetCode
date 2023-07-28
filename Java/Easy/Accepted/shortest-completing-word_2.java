class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        
        int[] count = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                count[Character.toLowerCase(c) - 'a']++;
            }
        }
        String result = null;
        for (String word : words) {
            if (result == null || word.length() < result.length()) {
                int[] temp = Arrays.copyOf(count, count.length);
                for (char c : word.toCharArray()) {
                    temp[c - 'a']--;
                }
                if (isComplete(temp)) {
                    result = word;
                }
            }
        }
        return result;
    }
    
    private boolean isComplete(int[] count) {
        for (int i : count) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }
}