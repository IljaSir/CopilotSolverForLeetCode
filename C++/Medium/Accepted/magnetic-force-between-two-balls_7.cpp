class Solution {
public:
    int maxDistance(vector<int>& position, int m) {
        
        sort(begin(position), end(position));
        int n = position.size();
        int low = 0;
        int high = position.back() - position.front();
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            int cnt = 1;
            int prev = position.front();
            for (int i = 1; i < n; ++i) {
                if (position[i] - prev >= mid) {
                    ++cnt;
                    prev = position[i];
                }
            }
            if (cnt >= m) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
};