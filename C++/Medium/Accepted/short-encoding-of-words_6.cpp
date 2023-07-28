class Solution {
public:
    int minimumLengthEncoding(vector<string>& words) {
        
        int n = words.size();
        unordered_set<string> s(words.begin(), words.end());
        for (auto w : words)
            for (int i = 1; i < w.size(); i++)
                s.erase(w.substr(i));
        int res = 0;
        for (auto w : s)
            res += w.size() + 1;
        return res;
    }
};