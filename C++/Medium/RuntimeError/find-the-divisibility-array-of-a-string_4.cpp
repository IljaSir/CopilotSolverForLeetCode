class Solution {
public:
    vector<int> divisibilityArray(string word, int m) {
        
        int n = word.length();
        vector<int> ans(n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum * 10 + word[i] - '0') % m;
            ans[i] = sum == 0;
        }
        return ans;
    }
};