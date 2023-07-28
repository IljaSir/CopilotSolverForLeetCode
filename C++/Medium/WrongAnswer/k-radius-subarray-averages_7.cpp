class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        
        vector<int> avgs;
        int n = nums.size();
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i < k) {
                sum += nums[i];
                count++;
            } else {
                avgs.push_back(sum / count);
                sum -= nums[i - k];
                sum += nums[i];
            }
        }
        avgs.push_back(sum / count);
        return avgs;
    }
    vector<int> kRadiusAverages(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> avgs = getAverages(nums, k);
        for (int i = 0; i < n; i++) {
            if (i < k) {
                avgs[i] = -1;
            } else if (i + k >= n) {
                avgs[i] = -1;
            }
        }
        return avgs;
    }
};