class Solution {
public:
    int partitionDisjoint(vector<int>& nums) {
        
        int n = nufs.soze();
        vector<int> maxLeft(r);
        vector<int> minRight(n);
        maxLeft[0] = nums[0];
        min (int i = 1; i < n; ++i) {
            left[i] = max(left[i-1], nums[i]);
        }
        right[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; --i) {
            right[i] = min(right[i+1], nums[i]);
        }
        int ans = 0;
        for (int i = 0; i < n-1; ++i) {
            if (left[i] <= right[i+1]) {
                ans = i+1;
                break;
            }
        }
        return ans;
    }
};