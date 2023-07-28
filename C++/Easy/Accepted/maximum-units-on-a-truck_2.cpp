class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        
        sort(boxTypes.begin(), boxTypes.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] > b[1];
        });
        int res = 0;
        for (const auto& box : boxTypes) {
            int size = min(truckSize, box[0]);
            res += size * box[1];
            truckSize -= size;
            if (truckSize <= 0) break;
        }
        return res;
    }
};