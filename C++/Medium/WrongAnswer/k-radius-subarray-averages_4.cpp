class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> avgs(n, 0);
        int sum = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            cnt++;
            if (i >= k) {
                sum -= nums[i-k];
                cnt--;
            }
            if (i >= k-1) {
                avgs[i] = sum / cnt;
            }
        }
        return avgs;
    }
    vector<int> kAverage(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> avgs(n, -1);
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                avgs[i] = nums[i];
            }
            return avgs;
        }
        if (k == n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
            }
            avgs[0] = sum / n;
            return avgs;
        }
        vector<int> left = getAverages(nums, k);
        reverse(nums.begin(), nums.end());
        vector<int> right = getAverages(nums, k);
        reverse(right.begin(), right.end());
        for (int i = 0; i < n; i++) {
            if (left[i] == -1 || right[i] == -1) {
                continue;
            }
            avgs[i] = (left[i] + right[i]) / 2;
        }
        return avgs;
    }
};