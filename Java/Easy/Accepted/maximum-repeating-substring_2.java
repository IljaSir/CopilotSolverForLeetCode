class Solution {
    public int maxRepeating(String sequence, String word) {
        
        int max = 0;
        for (int i = 0; i < sequence.length(); i++) {
            int count = 0;
            for (int j = i; j < sequence.length(); j++) {
                if (sequence.charAt(j) == word.charAt((j - i) % word.length())) {
                    if ((j - i + 1) % word.length() == 0) {
                        count++;
                    }
                } else {
                    break;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}