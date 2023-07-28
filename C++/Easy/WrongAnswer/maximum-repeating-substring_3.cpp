class Solution {
public:
    int maxRepeating(string sequence, string word) {
        
        int n = sequence.size();
        int m = word.size();
        int i = 0;
        int j = 0;
        int cnt = 0;
        while (i < n) {
            if (sequence[i] == word[j]) {
                i++;
                j++;
                if (j == m) {
                    cnt++;
                    j = 0;
                }
            } else {
                i++;
                j = 0;
            }
        }
        return cnt;
    }
};