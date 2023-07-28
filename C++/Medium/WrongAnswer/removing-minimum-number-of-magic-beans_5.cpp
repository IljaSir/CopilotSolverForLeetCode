class Solution {
public:
    long long minimumRemoval(vector<int>& beans) {
        
        long long sum = accumulate(beans.begin(), beans.end(), 0LL);
        int n = beans.size();
        long long m = sum / n;
        long long ans = 0;
        for (int i = 0; i < n; ++i) {
            if (beans[i] > m) {
                ans += beans[i] - m;
            }
        }
        return ans;
    }
};