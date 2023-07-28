class Solution {
public:
    long long repairCars(vector<int>& ranks, int cars) {
        
        long long res = 0;
        sort(ranks.begin(), ranks.end());
        int n = ranks.size();
        for(int i = 0; i < n; i++){
            int p = n - i - 1;
            long long cur = ranks[i] * (long long)(cars - p);
            res = max(res, cur);
        }
        return res;
    }
};