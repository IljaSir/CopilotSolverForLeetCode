class Solution {
public:
    int findRadius(vector<int>& houses, vector<int>& heaters) {
        
        int res = 0;
        int i = 0;
        sort(heaters.begin(), heaters.end());
        for (int house : houses) {
            while (i < heaters.size() - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i++;
            }
            res = max(res, abs(heaters[i] - house));
        }
        return res;
    }
};