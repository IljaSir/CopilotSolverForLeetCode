class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        
        int n = nums.size();
        vector<int> sum(n + 1, 0);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        vector<int> index(n);
        iota(index.begin(), index.end(), 0);
        sort(index.begin(), index.end(), [&](int a, int b) {
            return sum[a + 1] * (n - a) < sum[b + 1] * (n - b);
        });
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if ((sum[index[i] + 1] - sum[index[ans] + 1]) * (n - index[i]) < (sum[index[ans] + 1] - sum[index[i - 1] + 1]) * (n - index[ans])) {
                ans = i;
            }
        }
        return index[ans];
    }
};