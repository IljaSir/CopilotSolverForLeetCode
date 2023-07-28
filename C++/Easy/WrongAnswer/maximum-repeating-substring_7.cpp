class Solution {
public:
    int maxRepeating(string sequence, string word) {
        
        int count = 0;
        int i = 0;
        int j = 0;
        int n = sequence.size();
        int m = word.size();
        while (i < n) {
            if (sequence[i] == word[j]) {
                j++;
                if (j == m) {
                    count++;
                    j = 0;
                }
            } else {
                j = 0;
            }
            i++;
        }
        return count;
    }
};