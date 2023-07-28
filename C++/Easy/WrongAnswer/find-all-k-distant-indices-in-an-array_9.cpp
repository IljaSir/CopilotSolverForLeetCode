class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        
        vector<int> res;
        for(int i = 0; i < nums.size(); i++) {
            if(nums[i] == key) {
                res.push_back(i);
            }
        }
        if(res.size() <= 1) return res;
        int i = 0;
        int j = 1;
        while(j < res.size()) {
            if(res[j] - res[i] <= k) {
                j++;
            } else {
                res[i] = res[j];
                i++;
                j++;
            }
        }
        res.resize(i);
        return res;
    }
};