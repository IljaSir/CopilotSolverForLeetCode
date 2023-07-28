class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        
        int res = 0;
        sort(boxTypes.begin(), boxTypes.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] > b[1];
        });
        for (auto& box : boxTypes) {
            int n = min(box[0], truckSize);
            res += n * box[1];
            truckSize -= n;
            if (truckSize == 0) break;
        }
        return res;
    }
};