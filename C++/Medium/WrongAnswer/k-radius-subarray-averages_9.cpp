class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        
        vector<int> avgs;
        int n = nums.size();
        int sum = 0;
        int i = 0;
        for(; i < n; i++) {
            if(i <= k) {
                sum += nums[i];
                if(i == k) {
                    avgs.push_back(sum / (k + 1));
                }
            }
            else {
                sum += nums[i];
                sum -= nums[i - k - 1];
                avgs.push_back(sum / (k + 1));
            }
        }
        for(; i < n + k; i++) {
            sum -= nums[i - k - 1];
            avgs.push_back(sum / (k + 1));
        }
        for(int i = 0; i < k; i++) {
            avgs[i] = -1;
            avgs[avgs.size() - i - 1] = -1;
        }
        return avgs;
    }
};