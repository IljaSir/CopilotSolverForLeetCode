class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        
        int n = nums.size();
        deque<int> maxQ;
        deque<int> minQ;
        int l = 0;
        int r = 0;
        int ans = 0;
        while (r < n) {
            while (!maxQ.empty() && nums[r] > maxQ.back()) {
                maxQ.pop_back();
            }
            while (!minQ.empty() && nums[r] < minQ.back()) {
                minQ.pop_back();
            }
            maxQ.push_back(nums[r]);
            minQ.push_back(nums[r]);
            while (!maxQ.empty() && !minQ.empty() && maxQ.front() - minQ.front() > limit) {
                if (nums[l] == maxQ.front()) {
                    maxQ.pop_front();
                }
                if (nums[l] == minQ.front()) {
                    minQ.pop_front();
                }
                l++;
            }
            ans = max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
};