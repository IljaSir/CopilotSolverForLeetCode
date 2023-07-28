class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        
        int n = nums.size();
        int left = 0;
        int right = 0;
        int sum = 0;
        int ans = 0;
        unordered_set<int> s;
        while (right < n) {
            if (s.find(nums[right]) == s.end()) {
                s.insert(nums[right]);
                sum += nums[right];
                right++;
            } else {
                s.erase(nums[left]);
                sum -= nums[left];
                left++;
            }
            ans = max(ans, sum);
        }
        return ans;
    }
};