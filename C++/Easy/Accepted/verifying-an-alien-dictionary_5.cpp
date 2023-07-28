class Solution {
public:
    bool isAlienSorted(vector<string>& words, string order) {
        
        int n = words.size();
        if (n < 2) return true;
        vector<int> dict(26, 0);
        for (int i = 0; i < 26; ++i) {
            dict[order[i] - 'a'] = i;
        }
        for (int i = 0; i < n - 1; ++i) {
            if (!isSorted(words[i], words[i+1], dict)) return false;
        }
        return true;
    }
    bool isSorted(string& w1, string& w2, vector<int>& dict) {
        int n1 = w1.size(), n2 = w2.size();
        for (int i = 0; i < min(n1, n2); ++i) {
            if (w1[i] != w2[i]) {
                return dict[w1[i] - 'a'] < dict[w2[i] - 'a'];
            }
        }
        return n1 <= n2;
    }
};