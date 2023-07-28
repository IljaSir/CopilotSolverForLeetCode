class Solution {
public:
    int minCharacters(string a, string b) {
        
        vector<int> ca(26, 0), cb(26, 0);
        for (auto ch : a) {
            ++ca[ch - 'a'];
        }
        for (auto ch : b) {
            ++cb[ch - 'a'];);
        }
        return ans;
    }
};