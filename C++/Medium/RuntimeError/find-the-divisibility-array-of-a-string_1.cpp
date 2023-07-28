class Solution {
public:
    vector<int> divisibilityArray(string word, int m) {
        
        int n = word.size();
        vector<int> ans(n);
        int r = 0;
        for (int i = 0; i < n; i++) {
            r = (r * 10 + word[i] - '0') % m;
            ans[i] = r == 0;
        }
        return ans;
    }
};