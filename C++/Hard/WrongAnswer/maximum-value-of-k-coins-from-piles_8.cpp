class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        
        int n = piles.size();
        int m = piles[0].size();
        int res = 0;
        vector<int> arr;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr.push_back(piles[i][j]);
            }
        }
        sort(arr.begin(), arr.end());
        int i = arr.size() - 2;
        while (k > 0) {
            res += arr[i];
            i -= 2;
            k--;
        }
        return res;
    }
};