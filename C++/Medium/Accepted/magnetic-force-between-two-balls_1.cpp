class Solution {
public:
    int maxDistance(vector<int>& position, int m) {
        
        sort(position.begin(), position.end());
        int n = position.size();
        int l = 0, r = position[n - 1] - position[0];
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(position, mid, m)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
    bool check(vector<int>& position, int mid, int m) {
        int cnt = 1, n = position.size();
        int last = position[0];
        for (int i = 1; i < n; ++i) {
            if (position[i] - last >= mid) {
                ++cnt;
                last = position[i];
            }
        }
        return cnt >= m;
    }
};