class Solution {
public:
    int distinctAverages(vector<int>& nums) {
        
        int n = nums.size();
        set<double> s;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < n / 2; i++) {
            for (int j = n / 2; j < n; j++) {
                s.insert((nums[i] + nums[j]) / 2.0);
            }
        }
        return s.size();
    }
};