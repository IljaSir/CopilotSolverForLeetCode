class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        
        int n = words.size();
        vector<string> res;
        for (int i = 0; i < n; ++i) {
            string s = words[i];
            sort(s.begin(), s.end());
            bool flag = true;
            for (int j = i + 1; j < n; ++j) {
                string t = words[j];
                sort(t.begin(), t.end());
                if (s == t) {
                    flag = false;
                    break;
                }
            }
            if (flag) res.push_back(words[i]);
        }
        return res;
    }
};