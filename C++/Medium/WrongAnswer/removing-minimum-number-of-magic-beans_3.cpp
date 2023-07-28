class Solution {
public:
    long long minimumRemoval(vector<int>& beans) {
        
        sort(beans.begin(), beans.end());
        int n = beans.size();
        vector<int> pre(n, 0);
        pre[0] = beans[0];
        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + beans[i];
        }
        long long ans = 0;
        for(int i = 0; i < n; i++) {
            // [0, i] [i + 1, n - 1]
            int left = i + 1;
            int right = n - 1;
            int res = -1;
            while(left <= right) {
                int mid = (left + right) / 2;
                long long sum = pre[mid] - pre[i];
                long long cnt = mid - i;
                if(sum * 2 == cnt * beans[i]) {
                    res = mid;
                    break;
                } else if(sum * 2 > cnt * beans[i]) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if(res != -1) {
                ans += res - i;
            }
        }
        return ans;
    }
};