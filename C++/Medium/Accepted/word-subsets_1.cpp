class Solution {
public:
    vector<string> wordSubsets(vector<string>& words1, vector<string>& words2) {
        
        vector<int> maxFreq(26, 0);
        for (string &word : words2) {
            vector<int> freq = count(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = max(maxFreq[i], freq[i]);
            }
        }
        vector<string> res;
        for (string &word : words1) {
            vector<int> freq = count(word);
            bool flag = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.push_back(word);
            }
        }
        return res;
    }
    
    vector<int> count(string &word) {
        vector<int> freq(26, 0);
        for (char ch : word) {
            freq[ch - 'a']++;
        }
        return freq;
    }
};