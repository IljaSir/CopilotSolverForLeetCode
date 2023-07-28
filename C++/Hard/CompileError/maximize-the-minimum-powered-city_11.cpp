class Solution {
public:
    long long maxPower(vector<int>& stations, int r, int k) {
        
        int n = stations.size();
        int m = n + k;
        vector<int> v(m);
        for (int i = 0; i < n; i++) {
            v[i] = stations[i];
        }
        for (int i = n; i < m; i++) {
            v[i] = 0;
        }
        sort(v.begin(), v.end());
        long long ans = 0;
        for (int i = 0; i < m; i++) {
            long long l = v[i] - r;
            long long r = v[i] + r;
            int j = i;
            while (j < m && v[j] <= r) {
                j++;
            }
            ans = max(ans, j - i);
            i = j - 1;
        }
        return ans;
    }
};