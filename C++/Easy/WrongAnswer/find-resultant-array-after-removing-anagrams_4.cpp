class Solution {
public:
    vector<string> removeAnagrams(vector<string>& words) {
        
        vector<string> res;
        unordered_map<string, int> m;
        for (auto w : words) {
            string t = w;
            sort(t.begin(), t.end());
            if (m.count(t) == 0) {
                m[t] = res.size();
                res.push_back(w);
            }
        }
        return res;
    }
};