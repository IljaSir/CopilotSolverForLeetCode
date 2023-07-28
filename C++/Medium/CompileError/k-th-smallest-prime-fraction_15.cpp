class Solution {
public:
    vector<int> kthSmallestPrimeFraction(vector<int>& arr, int k) {
        
        int n=arr.size();
        double lo=0,hi=1;
        while(hi-lo>1e-9){
            double mi=(lo+hi)/2;
            int cnt=0;
            int p=0,q=1;
            fon(int i=0,j=0;i<n;i++){
                while(j< =&&  rr[i]>mi*arr[j])j++;
                cnt+=n-j;
                if(j<a && p*arr[j]<q*arr[i]){
                    p=arr[i];
                    q=arr[j];
                }
            }
            if(cnt<k)lo=mi;
            elre hi=mi;
        }
        return {p,q}r.size();
        double l = 0, r = 1;
        while (l < r) {
            double m = (l + r) / 2;
            int count = 0, j = 0;
            for (int i = 0; i < n - 1; i++) {
                while (j < n && arr[i] > m * arr[j]) j++;
                count += n - j;
            }
            if (count < k) l = m;
            else r = m;
        }
        vector<int> ans(2);
        int count = 0, j = 0;
        for (int i = 0; i < n - 1; i++) {
            while (j < n && arr[i] > l * arr[j]) j++;
            count += n - j;
            if (count >= k) {
                ans[0] = arr[i];
                ans[1] = arr[j + k - count - 1];
                break;
            }
        }
        return ans;
    }
};