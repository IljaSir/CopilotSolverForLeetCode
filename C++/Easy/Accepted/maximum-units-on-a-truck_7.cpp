class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        
        int ans = 0;
        sort(boxTypes.begin(), boxTypes.end(), [](const vector<int>& a, const vector<int>& b){
            return a[1] > b[1];
        });
        for (auto& boxType : boxTypes) {
            if (truckSize >= boxType[0]) {
                ans += boxType[0] * boxType[1];
                truckSize -= boxType[0];
            } else {
                ans += truckSize * boxType[1];
                break;
            }
        }
        return ans;
    }
};