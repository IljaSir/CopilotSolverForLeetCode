class Solution {
public:
    string truncateSentence(string s, int k) {
        
        string res;
        int i = 0;
        while(k) {
            if (s[i] == ' ') {
                k--;
            }
            res.push_back(s[i]);
            i++;
        }
        res.pop_back();
        return res;
    }
};