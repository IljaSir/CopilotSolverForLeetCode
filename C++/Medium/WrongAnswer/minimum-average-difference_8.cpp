class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        int n = nums.size();
        int res = 0;
        int min_val = 1e9;
        for (int i = 0; i < n - 1; i++) {
            nums[i + 1] += nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            int l = i + 1;
            int r = n - 1;
            int pos = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                int sum = nums[mid] - nums[i];
                int len = mid - i;
                int avg = sum / len;
                int avg2 = (sum + nums[n - 1] - nums[mid]) / (n - mid);
                if (avg <= avg2) {
                    pos = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (pos != -1) {
                int sum = nums[pos] - nums[i];
                int len = pos - i;
                int avg = sum / len;
                int avg2 = (sum + nums[n - 1] - nums[pos]) / (n - pos);
                int val = abs(avg - avg2);
                if (val < min_val) {
                    min_val = val;
                    res = i;
                }
            }
        }
        return res;
    }
};