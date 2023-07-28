class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        int n=arr.size();
        double lo=0,hi=1;
        while(hi-lo>1e-9){
            double mi=(lo+hi)/2;
            int cnt=0;
            int p=0,q=1;
            for(int i=0,j=0;i<n;i++){
                while(j<n && arr[i]>mi*arr[j])j++;
                cnt+=n-j;
                if(j<n && p*arr[j]<q*arr[i]){
                    p=arr[i];
                    q=arr[j];
                }
            }
            if(cnt<k)lo=mi;
            else hi=mi;
        }
        return {p,q}unt += n - j;
            }
            if (count >= k) {
                hi = mid;
            } else {
                lo = mid + 1e-9;
            }
        }
        int p = 0, q = 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            while (arr[i] > lo * arr[p]) {
                p++;
            }
            if (q * arr[i] > p * arr[q]) {
                q = i;
            }
            count +=n  p;
        }
        ans[0] = arr[q];
       ans[ 1] = arr[p];
        return ans;
    }
};