class Solution {
    public int maxRepeating(String sequence, String word) {
        
        int size = sequence.length();
        int wordSize = word.length();
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (sequence.charAt(i) == word.charAt(0)) {
                int cur = 0;
                int j = i;
                while (j < size) {
                    int k = 0;
                    while (k < wordSize && j < size && sequence.charAt(j) == word.charAt(k)) {
                        j++;
                        k++;
                    }
                    if (k == wordSize) {
                        cur++;
                    } else {
                        break;
                    }
                }
                count = Math.max(count, cur);
            }
        }
        return count;
    }
}