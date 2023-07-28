class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> v(n, 0);
        v[0] = nums[0];
        for (int i = 1; i < n; i++) {
            v[i] = v[i-1] + nums[i];
        }
        int ans = nums[0];
        int l = 0, r = 0;
        set<int> s;
        while (r < n) {
            while (r < n && !s.count(nums[r])) {
                s.insert(nums[r]);
                r++;
            }
            ans = max(ans, v[r-1] - v[l] + nums[l]);
            while (l < r && nums[l] != nums[r]) {
                s.erase(nums[l]);
                l++;
            }
            l++;
            r++;
        }
        return ans;
    }
};