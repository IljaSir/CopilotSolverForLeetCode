class Solution {
public:
    int countRangeSum(vector<int>& nums, int lower, int upper) {
        
        int n = nums.size();
        long long sum = 0;
        int res = 0;
        multiset<long long> s;
        s.insert(0);
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            res += distance(s.lower_bound(sum - upper), s.upper_bound(sum - lower));
            s.insert(sum);
        }
        return res;
    }
};