class Solution {
public:
    int maximumCount(vector<int>& nums) {
        
        int n = nums.size();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] < 0) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        int neg = i;
        i = 0;
        j = n - 1;
        while (i < j) {
            int mid = i + (j - i + 1) / 2;
            if (nums[mid] > 0) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        int pos = n - i - 1;
        return max(pos, neg);
    }
};