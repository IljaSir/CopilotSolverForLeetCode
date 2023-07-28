class Solution {
public:
    int similarPairs(vector<string>& words) {
        
        int n = words.size();
        vector<int> freq(26, 0);
        int res = 0;
        for (int i = 0; i < n; ++i) {
            vector<int> freq1(26, 0);
            for (char ch: words[i]) {
                ++freq1[ch - 'a'];
            }
            for (int j = 0; j < 26; ++j) {
                if (freq[j] > 0 && freq1[j] > 0) {
                    res += freq[j];
                }
            }
            for (int j = 0; j < 26; ++j) {
                freq[j] += freq1[j];
            }
        }
        return res;
    }
};