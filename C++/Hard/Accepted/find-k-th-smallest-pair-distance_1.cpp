class Solution {
public:
    int smallestDistancePair(vector<int>& nums, int k) {
        
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int l = 0, r = nums[n - 1] - nums[0];
        while (l < r) {
            int mid = l + r >> 1;
            int cnt = 0, i = 0;
            for (int j = 0; j < n; j ++) {
                while (i < n && nums[j] - nums[i] > mid) i ++;
                cnt += j - i;
            }
            if (cnt < k) l = mid + 1;
            else r = mid;
        }
        return l;
    }
};