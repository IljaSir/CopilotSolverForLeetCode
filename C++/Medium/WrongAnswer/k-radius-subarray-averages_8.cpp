class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> avgs(n, 0);
        int sum = 0;
        int start = 0;
        int end = 0;
        while (start < n) {
            while (end < n && end - start < k) {
                sum += nums[end];
                end++;
            }
            if (end - start == k) {
                avgs[start] = sum / k;
            }
            sum -= nums[start];
            start++;
        }
        return avgs;
    }
    vector<double> averageOfSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        vector<double> avgs(n, 0);
        int sum = 0;
        int start = 0;
        int end = 0;
        while (start < n) {
            while (end < n && end - start < k) {
                sum += nums[end];
                end++;
            }
            if (end - start == k) {
                avgs[start] = (double)sum / k;
            }
            sum -= nums[start];
            start++;
        }
        return avgs;
    }
    vector<double> averageOfSubarrays2(vector<int>& nums, int k) {
        int n = nums.size();
        vector<double> avgs(n, 0);
        int sum = 0;
        int start = 0;
        int end = 0;
        while (end < n) {
            sum += nums[end];
            end++;
            if (end - start == k) {
                avgs[start] = (double)sum / k;
                sum -= nums[start];
                start++;
            }
        }
        return avgs;
    }
    vector<double> averageOfSubarrays3(vector<int>& nums, int k) {
        int n = nums.size();
        vector<double> avgs(n, 0);
        int sum = 0;
        int start = 0;
        int end = 0;
        while (end < n) {
            sum += nums[end];
            end++;
            if (end - start == k) {
                avgs[start] = (double)sum / k;
                sum -= nums[start];
                start++;
            }
        }
        return avgs;
    }
};