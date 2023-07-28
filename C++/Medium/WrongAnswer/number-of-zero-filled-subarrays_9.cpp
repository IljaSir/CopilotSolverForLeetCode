class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        
        long long cnt = 0;
        long long sum = 0;
        map<long long, long long> m;
        m[0] = 1;
        for (auto x : nums) {
            sum += x;
            cnt += m[sum];
            m[sum]++;
        }
        return cnt;
    }
};