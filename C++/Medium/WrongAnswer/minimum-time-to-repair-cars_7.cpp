class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        
        long long ans = 0;
        sort(ranks.begin(), ranks.end());
        int n = ranks.size();
        for (int i = 0; i < n; i++) {
            long long x = ranks[i];
            long long y = cars / (i + 1);
            ans += x * y * y;
            cars -= y * (i + 1);
        }
        return ans;
    }
};