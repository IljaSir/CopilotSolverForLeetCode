class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        
        vector<int> avgs(nums.size());
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i > k) {
                sum -= nums[i - k - 1];
                count--;
            }
            if (i + k < nums.size()) {
                sum += nums[i + k];
                count++;
            }
            if (count > 0) {
                avgs[i] = sum / count;
            } else {
                avgs[i] = -1;
            }
        }
        return avgs;
    }
    vector<int> getAverages2(vector<int>& nums, int k) {
        vector<int> avgs(nums.size());
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i > k) {
                sum -= nums[i - k - 1];
            }
            if (i + k < nums.size()) {
                sum += nums[i + k];
            }
            if (i >= k) {
                avgs[i - k] = sum / (2 * k + 1);
            }
        }
        return avgs;
    }
    vector<int> getAverages3(vector<int>& nums, int k) {
        vector<int> avgs(nums.size());
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i > k) {
                sum -= nums[i - k - 1];
            }
            if (i + k < nums.size()) {
                sum += nums[i + k];
            }
            if (i >= k) {
                avgs[i - k] = sum / (2 * k + 1);
            }
        }
        return avgs;
    }
    vector<int> getAverages4(vector<int>& nums, int k) {
        vector<int> avgs(nums.size());
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (i > k) {
                sum -= nums[i - k - 1];
            }
            if (i + k < nums.size()) {
                sum += nums[i + k];
            }
            if (i >= k) {
                avgs[i - k] = sum /
    }
};