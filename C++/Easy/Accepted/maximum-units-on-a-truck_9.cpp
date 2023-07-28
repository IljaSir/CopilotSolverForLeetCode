class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        
        int unit = 0;
        sort(boxTypes.begin(), boxTypes.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] > b[1];
        });
        
        for (int i = 0; i < boxTypes.size(); i++) {
            if (truckSize >= boxTypes[i][0]) {
                unit += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            } else {
                unit += truckSize * boxTypes[i][1];
                break;
            }
        }
        
        return unit;
    }
};