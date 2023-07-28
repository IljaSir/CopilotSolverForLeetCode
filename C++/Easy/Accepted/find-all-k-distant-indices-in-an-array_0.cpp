class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        
        vector<int> ret;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == key) {
                for (int j = max(0, i - k); j <= min(i + k, (int)nums.size() - 1); j++) {
                    ret.push_back(j);
                }
            }
        }
        sort(ret.begin(), ret.end());
        ret.erase(unique(ret.begin(), ret.end()), ret.end());
        return ret;
    }
};