class Solution {
public:
    vector<int> findOriginalArray(vector<int>& changed) {
        
        if (changed.size() % 2 != 0) return {};
        sort(changed.begin(), changed.end());
        vector<int> ans;
        for (int i = 0; i < changed.size(); i += 2) {
            if (changed[i] != changed[i + 1]) return {};
            ans.push_back(changed[i]);
        }
        return ans;
    }
};