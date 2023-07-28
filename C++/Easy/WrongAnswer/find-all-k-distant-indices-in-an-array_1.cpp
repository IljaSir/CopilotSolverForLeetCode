class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == key) {
                res.push_back(i);
            }
        }
        int i = 0, j = 0;
        while (i < res.size()) {
            while (j < res.size() && res[j] - res[i] <= k) {
                j++;
            }
            if (j - i > k) {
                res.erase(res.begin() + i);
            } else {
                i++;
            }
        }
        return res;
    }
};