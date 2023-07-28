class Solution {
public:
    vector<int> divisibilityArray(string word, int m) {
        
        int n = word.size();
        vector<int> res(n);
        int val = 0;
        for (int i = 0; i < n; i++) {
            val = (val * 10 + word[i] - '0') % m;
            res[i] = val == 0;
        }
        return res;
    }
};