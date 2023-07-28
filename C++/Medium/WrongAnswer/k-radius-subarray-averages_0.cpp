class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> avgs(n);
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            int count = 0;
            for (int j = i - k; j <= i + k; ++j) {
                if (j >= 0 && j < n) {
                    sum += nums[j];
                    count++;
                }
            }
            avgs[i] = count > 0 ? sum / count : -1;
        }
        return avgs;
    }
};