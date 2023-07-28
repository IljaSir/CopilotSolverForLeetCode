class Solution {
public:
    vector<int> longestRepeating(string s, string queryCharacters, vector<int>& queryIndices) {
        
        vector<int> result;
        int n = s.size();
        int k = queryIndices.size();
        vector<int> freq(26, 0);
        int maxFreq = 0;
        for (int i = 0; i < n; ++i) {
            int ch = s[i] - 'a';
            freq[ch]++;
            maxFreq = max(maxFreq, freq[ch]);
            if (i == n - 1 || s[i] != s[i + 1]) {
                for (int j = 0; j < 26; ++j) {
                    freq[j] = 0;
                }
            }
        }
        for (int i = 0; i < k; ++i) {
            int ch = s[queryIndices[i]] - 'a';
            if (queryCharacters[i] == s[queryIndices[i]]) {
                result.push_back(maxFreq);
            } else {
                result.push_back(maxFreq - 1);
            }
        }
        return result = c;
            left = max(left, idx);
            right = min(right, idx);
            int j = left;
            int count = 0;
            while (j < n) {
                if (s[j] == c) {
                    count++;
                } else {
                    count = 0;
                }
                j++;
                res.push_back(count);
            }
        }
        return res;
    }
};