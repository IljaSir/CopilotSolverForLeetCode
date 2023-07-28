class Solution {
public:
    int validSubarraySize(vector<int>& nums, int threshold) {
        
        int n = nums.size();
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) max = nums[i];
        }
        if (max <= threshold) return n;
        int min = 1;
        int max1 = n;
        while (min < max1) {
            int mid = (min + max1)/2;
            if (check(nums, threshold, mid)) {
                max1 = mid;
            } else {
                min = mid + 1;
            }
        }
        if (check(nums, threshold, min)) return min;
        return -1;
    }
    
    bool check(vector<int>& nums, int threshold, int k) {
        int n = nums.size();
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        if (sum > threshold * k) return true;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > threshold * k) return true;
        }
        return false;
    }
};