class Solution {
public:
    int numOfSubarrays(vector<int>& arr) {
        
        long long ans = 0;
        long long sum = 0;
        long long cnt[2] = {1, 0};
        for (int i : arr) {
            sum += i;
            ans += cnt[sum % 2];
            cnt[sum % 2]++;
        }
        return ans % 1000000007;
    }
};