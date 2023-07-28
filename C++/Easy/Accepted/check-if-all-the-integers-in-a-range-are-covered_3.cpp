class Solution {
public:
    bool isCovered(vector<vector<int>>& ranges, int left, int right) {
        
        vector<int> a(52, 0);
        for (auto r : ranges) {
            a[r[0]]++;
            a[r[1] + 1]--;
        }
        for (int i = 1; i <= 50; i++) {
            a[i] += a[i - 1];
        }
        for (int i = left; i <= right; i++) {
            if (a[i] == 0) return false;
        }
        return true;
    }
};