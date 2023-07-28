class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        
        unordered_map<int, int> left, right, count;
        for (int i = 0; i < nums.size(); i++) {
            if (left.find(nums[i]) == left.end()) {
                left[nums[i]] = i;
            }
            right[nums[i]] = i;
            count[nums[i]]++;
        }
        int ans = nums.size();
        int degree = 0;
        for (auto& kv : count) {
            if (kv.second > degree) {
                degree = kv.second;
                ans = right[kv.first] - left[kv.first] + 1;
            }
            else if (kv.second == degree) {
                ans = min(ans, right[kv.first] - left[kv.first] + 1);
            }
        }
        return ans;
    }
};