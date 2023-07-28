class Solution {
public:
    int maxDistance(vector<int>& position, int m) {
        
        sort(position.begin(), position.end());
        int n = position.size();
        int l = 1;
        int r = position[n-1] - position[0];
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            int count = 1;
            int pre = position[0];
            for (int i = 1; i < n; ++i) {
                if (position[i] - pre >= mid) {
                    count++;
                    pre = position[i];
                }
            }
            if (count >= m) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
};