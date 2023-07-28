class Solution {
public:
    vector<int> targetIndices(vector<int>& nums, int target) {
        
        vector<int> sorted = nums;
        sort(sorted.begin(), sorted.end());
        vector<int> res;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == target) {
                for (int j = 0; j < sorted.size(); j++) {
                    if (sorted[j] == target) {
                        res.push_back(j);
                        sorted[j] = -1;
                        break;
                    }
                }
            }
        }
        return res;
    }
};