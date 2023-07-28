class Solution {
public:
    int maxSizeSlices(vector<int>& slices) {
        
        int n = slices.size();
        int m = n / 3;
        return max(solve(slices, 0, n - 2, m), solve(slices, 1, n - 1, m));
    }
};