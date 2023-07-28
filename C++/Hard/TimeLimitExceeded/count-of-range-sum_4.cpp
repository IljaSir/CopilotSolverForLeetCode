class Solution {
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        
        int n = nums.size();
        long long sum = 0;
        multiset<long long> s;
        s.insert(0);
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            auto it = s.lower_bound(sum - upper);
            while (it != s.end() && *it <= sum - lower) {
                ++ans;
                ++it;
            }
            s.insert(sum);
        }
        return ans;
    }
};