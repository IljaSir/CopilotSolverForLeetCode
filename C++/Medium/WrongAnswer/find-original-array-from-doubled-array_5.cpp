class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        
        vector<int> res;
        if (changed.size() % 2 == 1) {
            return res;
        }
        sort(changed.begin(), changed.end());
        int prev = -1;
        for (int i = 0; i < changed.size(); i += 2) {
            if (changed[i] != changed[i + 1] || changed[i] == prev) {
                return res;
            }
            res.push_back(changed[i]);
            prev = changed[i];
        }
        return res;
    }
};