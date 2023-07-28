class Solution {
public:
    long long makeSubKSumEqual(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<int> prefixSum(n+1, 0);
        for(int i = 0; i < n; i++){
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }
        long long res = LONG_LONG_MAX;
        unordered_map<int, int> count;
        for(int i = 0; i < n; i++){
            int mod = prefixSum[i+1] % k;
            if(mod < 0) mod += k;
            if(mod == 0){
                res = min(res, (long long)prefixSum[i+1] / k);
                continue;
            }
            int target = (prefixSum[i+1] / k + 1) * k;
            int need = target - prefixSum[i+1];
            if(count.count(mod)){
                res = min(res, (long long)(prefixSum[i+1] - prefixSum[count[mod]]) / k);
            }
            count[mod] = i+1;
        }
        return res;
    }
};