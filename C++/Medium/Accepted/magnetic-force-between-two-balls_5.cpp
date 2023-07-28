class Solution {
public:
    int maxDistance(vector<int>& position, int m) {
        
        sort(position.begin(), position.end());
        int n = position.size();
        int left = 0, right = position[n-1] - position[0];
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            int count = 1, pre = position[0];
            for (int i = 1; i < n; ++i) {
                if (position[i] - pre >= mid) {
                    ++count;
                    pre = position[i];
                }
            }
            if (count >= m) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
};