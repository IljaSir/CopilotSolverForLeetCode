class Solution {
public:
    int similarPairs(vector<string>& words) {
        
        int res = 0;
        for (int i = 0; i < words.size(); ++i) {
            for (int j = i + 1; j < words.size(); ++j) {
                if (i != j && isSimilar(words[i], words[j])) {
                    ++res;
                }
            }
        }
        return res;
    }
    
    bool isSimilar(const string& w1, const string& w2) {
        if (w1.length() != w2.length()) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < w1.length(); ++i) {
            if (w1[i] != w2[i]) {
                ++diff;
            }
            if (diff > 2) {
                return false;
            }
        }
        return true;
    }
};