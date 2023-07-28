class Solution {
public:
    int maxRepeating(string sequence, string word) {
        
        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        while (i < sequence.length()) {
            if (sequence[i] == word[j]) {
                j++;
                if (j == word.length()) {
                    j = 0;
                    count++;
                }
            } else {
                if (count > max) {
                    max = count;
                }
                count = 0;
                j = 0;
            }
            i++;
        }
        if (count > max) {
            max = count;
        }
        return max;
    }
};