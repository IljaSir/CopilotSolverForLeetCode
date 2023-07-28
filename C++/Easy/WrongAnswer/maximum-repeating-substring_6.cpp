class Solution {
public:
    int maxRepeating(string sequence, string word) {
        
        int n = sequence.length();
        int m = word.length();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int j = 0;
            int k = i;
            while(k < n && j < m && sequence[k] == word[j]) {
                k++;
                j++;
                if(j == m) {
                    j = 0;
                    ans++;
                }
            }
        }
        return ans;
    }
};