class Solution {
public:
    vector<string> commonChars(vector<string>& words) {
        
        vector<string> ans;
        int n = words.size();
        if (n == 0) return ans;
        vector<int> freq(26, 0);
        for (auto c : words[0]) {
            freq[c - 'a']++;
        }
        for (int i = 1; i < n; i++) {
            vector<int> freq2(26, 0);
            for (auto c : words[i]) {
                freq2[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                freq[j] = min(freq[j], freq2[j]);
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                string s;
                s.push_back(i + 'a');
                for (int j = 0; j < freq[i]; j++) {
                    ans.push_back(s);
                }
            }
        }
        return ans;
    }
};