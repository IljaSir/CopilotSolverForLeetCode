class Solution {
public:
    int maximumBags(vector<int>& capacity, vector<int>& rocks, int additionalRocks) {
        
        int n = capacity.size();
        int l = 0, r = n;
        int ans = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(capacity, rocks, additionalRocks, mid)) {
                ans = max(ans, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
    
    bool check(vector<int>& capacity, vector<int>& rocks, int additionalRocks, int mid) {
        int n = capacity.size();
        vector<int> diff(n);
        for (int i = 0; i < n; ++i) {
            diff[i] = capacity[i] - rocks[i];
        }
        sort(diff.begin(), diff.end(), greater<int>());
        int sum = 0;
        for (int i = 0; i < mid; ++i) {
            sum += diff[i];
        }
        return sum <= additionalRocks;
    }
};