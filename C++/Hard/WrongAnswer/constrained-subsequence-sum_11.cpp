class Solution {
public:
    int constrainedSubsetSum(vector<int>& nums, int k) {
        
        int n = nums.size();
        int ans = INT_MIN;
        deque<int> q;
        for(int i = 0; i < n; i++) {
            if(!q.empty()) {
                nums[i] = nums[i] + q.front();
            }
            ans = max(ans, nums[i]);
            while(!q.empty() && q.back() < nums[i]) {
                q.pop_back();
            }
            q.push_back(nums[i]);
            if(i >= k && q.front() == nums[i - k]) {
                q.pop_front();
            }
        }
        return ans;
    }
};