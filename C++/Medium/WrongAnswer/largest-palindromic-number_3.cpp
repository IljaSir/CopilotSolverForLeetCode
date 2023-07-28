class Solution {
public:
    string largestPalindromic(string num) {
        
        int n = num.size();
        vector<int> cnt(10);
        for(char c : num) cnt[c - '0']++;
        for(int i = 9; i >= 0; i--) {
            if(cnt[i]) {
                cnt[i]--;
                string s = num;
                s += ('0' + i);
                for(int j = 9; j >= 0; j--) {
                    for(int k = 0; k < cnt[j]; k++) {
                        s += ('0' + j);
                    }
                }
                return s;
            }
        }
        return "";
    }
};