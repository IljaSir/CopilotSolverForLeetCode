class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        
        int n = words.size();
        vector<int> minFreq(26, INT_MAX);
        for (int i = 0; i < n; i++) {
            vector<int> freq(26, 0);
            for (char c : words[i]) {
                freq[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                minFreq[j] = min(minFreq[j], freq[j]);
            }
        }
        vector<string> ans;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                ans.push_back(string(1, i + 'a'));
            }
        }
        return ans;
    }
};