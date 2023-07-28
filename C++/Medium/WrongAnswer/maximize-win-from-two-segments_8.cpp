class Solution {
public:
    int maximizeWin(vector<int>& prizePositions, int k) {
        
        int n = prizePositions.size();
        int res = 0;
        for(int i = 0; i < n; ++i){
            int l = i, r = n - 1;
            while(l < r){
                int mid = l + (r - l + 1)/2;
                if(prizePositions[mid] - prizePositions[i] <= k) l = mid;
                else r = mid - 1;
            }
            res = max(res, l - i + 1);
        }
        return res;
    }
};