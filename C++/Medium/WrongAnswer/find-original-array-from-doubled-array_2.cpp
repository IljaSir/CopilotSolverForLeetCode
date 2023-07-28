class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        
        if (changed.size() % 2) return {};
        sort(changed.begin(), changed.end());
        vector<int> res;
        int i = 0, j = 1;
        while (j < changed.size()) {
            if (changed[i] == changed[j]) {
                res.push_back(changed[i]);
                i += 2;
                j += 2;
            } else if (changed[i] < changed[j]) {
                return {};
            } else {
                j++;
            }
        }
        return res;
    }
};