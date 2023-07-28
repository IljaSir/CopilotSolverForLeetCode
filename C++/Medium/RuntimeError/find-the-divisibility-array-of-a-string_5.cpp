class Solution {
public:
    vector<int> divisibilityArray(string word, int m) {
        
        vector<int> res;
        int n = word.size();
        int val = 0;
        for (int i = 0; i < n; ++i) {
            val = (val * 10 + (word[i] - '0')) % m;
            res.push_back(val == 0 ? 1 : 0);
        }
        return res;
    }
};