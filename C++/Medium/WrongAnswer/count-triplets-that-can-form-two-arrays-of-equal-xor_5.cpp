class Solution {
public:
    int countTriplets(vector<int>& arr) {
        
        int n = arr.size();
        vector<int> pre(n);
        pre[0] = arr[0];
        for (int i = 1; i < n; ++i)
            pre[i] = pre[i - 1] ^ arr[i];
        int ans = 0;
        for (int i = 0; i < n; ++i)
            for (int k = i + 1; k < n; ++k)
                if ((pre[k - 1] ^ (i > 0 ? pre[i - 1] : 0)) == pre[n - 1] ^ pre[k])
                    ans += k - i;
        return ans;
    }
};