class Solution {
public:
    int maxValueOfCoins(vector<vector<int>>& piles, int k) {
        
        int n = piles.size();
        int m = piles[0].size();
        vector<int> v;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                v.push_back(piles[i][j]);
            }
        }
        sort(v.begin(), v.end());
        int sum = 0;
        for(int i=n*m-2; i>=n*m-k; i-=2) {
            sum += v[i];
        }
        return sum;
    }
};