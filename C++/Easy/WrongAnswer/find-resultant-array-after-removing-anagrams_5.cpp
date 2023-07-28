class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        
        unordered_map<string, int> freq;
        for (string s : words) {
            string t = s;
            sort(t.begin(), t.end());
            freq[t]++;
        }
        vector<string> res;
        for (string s : words) {
            string t = s;
            sort(t.begin(), t.end());
            if (freq[t] == 1) res.push_back(s);
        }
        return res;
    }
};