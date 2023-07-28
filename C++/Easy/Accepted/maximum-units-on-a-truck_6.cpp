class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        
        sort(boxTypes.begin(), boxTypes.end(), [](auto& a, auto& b) {
            return a[1] > b[1];
        });
        int ans = 0;
        for (auto& boxType: boxTypes) {
            if (truckSize <= 0) break;
            int n = min(truckSize, boxType[0]);
            ans += n * boxType[1];
            truckSize -= n;
        }
        return ans;
    }
};