class Solution {
public:
    vector<int> getAverages(vector<int>& nums, int k) {
        
        int n = nums.size();
        vector<int> avgs(n);
        int sum = 0;
        int i = 0;
        for (; i < k; ++i) {
            sum += nums[i];
        }
        for (int j = 0; j < n; ++j) {
            avgs[j] = sum / (i - j);
            if (i < n) {
                sum += nums[i];
            }
            ++i;
        }
        return avgs;
    }
    vector<int> getAverages2(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> avgs(n);
        int sum = 0;
        int i = 0;
        for (; i < k; ++i) {
            sum += nums[i];
        }
        for (int j = 0; j < n; ++j) {
            avgs[j] = sum / (i - j);
            if (i < n) {
                sum += nums[i];
            }
            ++i;
        }
        return avgs;
    }
    vector<int> getAverages3(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> avgs(n);
        int sum = 0;
        int i = 0;
        for (; i < k; ++i) {
            sum += nums[i];
        }
        for (int j = 0; j < n; ++j) {
            avgs[j] = sum / (i - j);
            if (i < n) {
                sum += nums[i];
            }
            ++i;
        }
        return avgs;
    }
    vector<int> getAverages4(vector<int>& nums, int k) {
        int n = nums.size();
        vector<int> avgs(n);
        int sum = 0;
        int i = 0;
        for (; i < k; ++i) {
            sum += nums[i];
        }
        for (int j = 0; j < n; ++j) {
            avgs[j] = sum / (i - j);
            if (i < n) {
                sum += nums[i];
            }
            ++i;
        }
        return avgs;
    }
};