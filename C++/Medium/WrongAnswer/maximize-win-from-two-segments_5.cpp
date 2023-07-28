class Solution {
public:
    int maximizeWin(vector<int>& prizePositions, int k) {
        
        int n = prizePositions.size();
        int res = 0;
        for(int i = 0; i < n; i++){
            int j = i;
            while(j < n && prizePositions[j] - prizePositions[i] <= k) j++;
            res = max(res, j - i);
        }
        return res;
    }
};