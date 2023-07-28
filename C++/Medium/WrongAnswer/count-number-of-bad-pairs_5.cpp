class Solution {
public:
    long long countBadPairs(vector<int>& nums) {
        
        int n = nums.size();
        long long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1, mid, pos = -1;
            while (l <= r) {
                mid = l + r >> 1;
                if (nums[mid] - mid >= nums[i] - i) {
                    pos = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (pos != -1) ans += n - pos;
        }
        return ans;
    }
};