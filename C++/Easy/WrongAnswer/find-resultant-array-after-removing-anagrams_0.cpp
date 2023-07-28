class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        
        unordered_map<string, int> hash;
        for (int i = 0; i < words.size(); i++) {
            string s = words[i];
            sort(s.begin(), s.end());
            hash[s]++;
        }
        vector<string> res;
        for (int i = 0; i < words.size(); i++) {
            string s = words[i];
            sort(s.begin(), s.end());
            if (hash[s] == 1) {
                res.push_back(words[i]);
            }
        }
        return res;
    }
};