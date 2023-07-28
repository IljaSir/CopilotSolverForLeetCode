class Solution {
public:
    int minimumDifference(vector<int>& nums) {
        
        int n = nums.size() / 2;
        int sum = 0;
        for (int i = 0; i < nums.size(); ++i) {
            sum += nums[i];
        }
        vector<int> v1;
        vector<int> v2;
        for (int i = 0; i < n; ++i) {
            v1.push_back(i);
            v2.push_back(i + n);
        }
        int min_diff = INT_MAX;
        do {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < n; ++i) {
                sum1 += nums[v1[i]];
                sum2 += nums[v2[i]];
            }
            min_diff = min(min_diff, abs(sum1 - sum2));
        } while (next_permutation(v1.begin(), v1.end()));
        return min_diff;
    }
};