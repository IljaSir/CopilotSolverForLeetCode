class Solution {
public:
    vector<int> divisibilityArray(string word, int m) {
        
        vector<int> res;
        int mod = 0;
        for (int i = 0; i < word.size(); i++) {
            mod = (mod * 10 + (word[i] - '0')) % m;
            res.push_back(mod == 0);
        }
        return res;
    }
};