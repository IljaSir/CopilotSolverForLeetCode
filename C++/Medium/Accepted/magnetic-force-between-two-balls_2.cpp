class Solution {
public:
    int maxDistance(vector<int>& position, int m) {
        
        sort(position.begin(), position.end());
        int n = position.size();
        int l = 0, r = position[n - 1] - position[0];
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(position, m, mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }
    bool check(vector<int>& position, int m, int d) {
        int cnt = 1, last = position[0];
        for (int i = 1; i < position.size(); i ++ ) {
            if (position[i] - last >= d) {
                cnt ++ ;
                last = position[i];
            }
        }
        return cnt >= m;
    }
};