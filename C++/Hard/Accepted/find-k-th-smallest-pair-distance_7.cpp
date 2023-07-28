class Solution {
public:
    int smallestDistancePair(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int l = 0, r = nums.back() - nums.front();
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cnt = 0, start = 0;
            for (int i = 0; i < nums.size(); ++i) {
                while (nums[i] - nums[start] > mid) ++start;
                cnt += i - start;
            }
            if (cnt < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }
};