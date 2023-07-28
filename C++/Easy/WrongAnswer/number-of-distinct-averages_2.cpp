class Solution {
public:
    int distinctAverages(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        set<double> res;
        for (int i = 0; i < n / 2; i++) {
            for (int j = n / 2; j < n; j++) {
                res.insert((nums[i] + nums[j]) / 2.0);
            }
        }
        return res.size();
    }
};