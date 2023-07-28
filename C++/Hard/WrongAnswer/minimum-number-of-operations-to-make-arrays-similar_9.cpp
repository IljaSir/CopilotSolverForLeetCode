class Solution {
public:
    long long makeSimilar(vector<int>& nums, vector<int>& target) {
        
        long long res = 0;
        for (int i = 0; i < nums.size(); ++i) {
            res += abs(nums[i] - target[i]);
        }
        return res;
    }
    int minOperations(vector<int>& nums, vector<int>& target) {
        long long sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums.size(); ++i) {
            sum1 += nums[i];
            sum2 += target[i];
        }
        if (sum1 == sum2) return 0;
        if (sum1 > sum2) {
            return minOperations(nums, target);
        }
        long long diff = sum2 - sum1;
        if (diff % 2 != 0) return -1;
        diff /= 2;
        vector<int> d1, d2;
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] > target[i]) {
                d1.push_back(nums[i] - target[i]);
            } else if (nums[i] < target[i]) {
                d2.push_back(target[i] - nums[i]);
            }
        }
        sort(d1.begin(), d1.end());
        sort(d2.begin(), d2.end());
        int res = 0;
        for (int i = d1.size() - 1; i >= 0; --i) {
            diff -= d1[i];
            ++res;
            if (diff <= 0) break;
        }
        if (diff > 0) {
            for (int i = d2.size() - 1; i >= 0; --i) {
                diff -= d2[i];
                ++res;
                if (diff <= 0) break;
            }
        }
        if (diff > 0) return -1;
        return res;
    }
};