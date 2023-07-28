class Solution {
public:
    int longestBeautifulSubstring(string word) {
        
        int n = word.size();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            int j = i;
            int cnt = 1;
            while(j < n - 1 && word[j] <= word[j + 1]) {
                if(word[j] != word[j + 1]) {
                    cnt++;
                }
                j++;
            }
            if(cnt == 5) {
                ans = max(ans, j - i + 1);
            }
            i = j;
        }
        return ans;
    }
};