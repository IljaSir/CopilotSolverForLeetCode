class Solution {
public:
    int maximizeGreatness(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> v = nums;
        sort(v.begin(), v.end());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < v[i]) ans++;
        }
        return ans;
    }
};