class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        
        int n = nums.size();
        int sum = 0;
        vector<int> avgs(n);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                avgs[i - k + 1] = sum / k;
            }
        }
        return avgs;
    }
    vector<int> getAverages(vector<int>& nums, int k) {
        int n = nums.size();
        int sum = 0;
        vector<int> avgs(n);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                avgs[i - k + 1] = sum / k;
            }
        }
        return avgs;
    }
    vector<int> getAverages(vector<int>& nums, int k) {
        int n = nums.size();
        int sum = 0;
        vector<int> avgs(n);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                avgs[i - k + 1] = sum / k;
            }
        }
        return avgs;
    }
    vector<int> getAverages(vector<int>& nums, int k) {
        int n = nums.size();
        int sum = 0;
        vector<int> avgs(n);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                avgs[i - k + 1] = sum / k;
            }
        }
        return avgs;
    }
};