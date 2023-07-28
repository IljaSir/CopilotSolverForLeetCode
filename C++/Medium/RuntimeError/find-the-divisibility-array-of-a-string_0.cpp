class Solution {
public:
    vector<int> divisibilityArray(string word, int m) {
        
        int n = word.size();
        vector<int> ans(n);
        int num = 0;
        for (int i = 0; i < n; ++i) {
            num = (num * 10 + word[i] - '0') % m;
            ans[i] = num == 0;
        }
        return ans;
    }
};