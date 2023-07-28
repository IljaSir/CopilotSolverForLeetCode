class Solution {
public:
    int numSpecialEquivGroups(vector<string>& words) {
        
        unordered_set<string> s;
        for (string w : words) {
            string odd, even;
            for (int i = 0; i < w.size(); ++i) {
                if (i & 1) odd += w[i];
                else even += w[i];
            }
            sort(odd.begin(), odd.end());
            sort(even.begin(), even.end());
            s.insert(odd + even);
        }
        return s.size();
    }
};