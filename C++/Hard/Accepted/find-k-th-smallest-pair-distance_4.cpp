class Solution {
public:
    int smallestDistancePair(vector<int>& nums, int k) {
        
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int l = 0, r = nums[n - 1] - nums[0];
        while (l < r) {
            int mid = l + r >> 1;
            int cnt = 0, j = 0;
            for (int i = 0; i < n; i++) {
                while (j < n && nums[j] - nums[i] <= mid) j++;
                cnt += j - i - 1;
            }
            if (cnt >= k) r = mid;
            else l = mid + 1;
        }
        return l;
    }
};