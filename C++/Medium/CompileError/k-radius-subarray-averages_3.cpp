class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> avgs(n);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            count++;
            if (i >= k) {
                sum -= nums[i - k];
                count--;
            }
            if (i >= k - 1) {
                avgs[i - k + 1] = sum / count;
            }
        }
        return avgs;
    }
    vector<int> getAverages2(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> avgs(n);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            count++;
            if (i >= k) {
                sum -= nums[i - k];
                count--;
            }
            if (i >= k - 1) {
                avgs[i - k + 1] = sum / count;
            }
        }
        return avgs;
    }
    vector<double> getAverages3(vector<int>& nums, int k) {
        int n = nums.size();
        vector<double> avgs(n);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            count++;
            if (i >= k) {
                sum -= nums[i - k];
                count--;
            }
            if (i >= k - 1) {
                avgs[i - k + 1] = (double)sum / count;
            }
        }
        return avgs;
    }
    vector<double> getAverages4(vector<int>& nums, int k) {
        int n = nums.size();
        vector<double> avgs(n);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            count++;
            if (i >= k) {
                sum -= nums[i - k];
                count--;
            }
            if (i >= k - 1) {
                avgs[i - k + 1] = ((double)sum) / count;
            }
        }
    }
};