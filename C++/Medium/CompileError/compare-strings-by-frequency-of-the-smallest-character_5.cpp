class Solution {
public:
    vector<int> numSmallerByFrequency(vector<string>& queries, vector<string>& words) {
        
        vector<int> res;
        vector<int> fwords;
        for (auto w : words) {
            fwords.push_back(f(w));
        }
        sort(fwords.begin(), fwords.end());
        for (auto q : queries) {
            int fq = f(q);
            auto it = upper_bound(fwords.begin(), fwords.end(), fq);
            res.push_back(fwords.end() - it);
        }
        return res;
    }
};