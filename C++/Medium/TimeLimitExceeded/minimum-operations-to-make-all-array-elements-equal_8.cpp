class Solution {
public:
    vector<long long> minOperations(vector<int>& nums, vector<int>& queries) {
        
        vector<long long> res;
        vector<int> hash(100001, 0);
        for (auto n: nums) hash[n]++;
        vector<long long> prefix(100001, 0);
        for (int i = 1; i <= 100000; i++) prefix[i] = prefix[i-1] + hash[i];
        for (auto q: queries) {
            long long sum = 0;
            for (int i = 1; i <= 100000; i++) {
                sum += abs(i - q) * (prefix[i] - prefix[i-1]);
            }
            res.push_back(sum);
        }
        return res;
    }
};