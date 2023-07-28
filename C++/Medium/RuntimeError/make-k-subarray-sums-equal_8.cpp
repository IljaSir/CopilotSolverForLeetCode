class Solution {
public:
    long long makeSubKSumEqual(vector<int>& arr, int k) {
        
        int n = arr.size();
        vector<long long> pre(n+1);
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + arr[i];
        }
        long long res = 1e18;
        for(int i=0;i<n;i++){
            long long sum = pre[i+k] - pre[i];
            if(sum == 0){
                res = min(res, (long long)k);
            }
            else{
                for(int j=1;j<=k;j++){
                    if(sum%j == 0){
                        long long target = sum/j;
                        long long cnt = 0;
                        for(int p=0;p<j;p++){
                            long long l = i + p*(k/j);
                            long long r = i + (p+1)*(k/j);
                            long long mid = (l+r)/2;
                            cnt += pre[mid] - pre[l];
                            cnt += pre[r] - pre[mid];
                        }
                        res = min(res, cnt);
                    }
                }
            }
        }
        return res;
    }
};