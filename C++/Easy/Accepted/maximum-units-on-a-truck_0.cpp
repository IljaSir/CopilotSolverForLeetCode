class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        
        sort(boxTypes.begin(), boxTypes.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] > b[1];
        });
        int ans = 0;
        for (auto& box : boxTypes) {
            if (truckSize == 0) break;
            int cnt = min(truckSize, box[0]);
            ans += cnt * box[1];
            truckSize -= cnt;
        }
        return ans;
    }
};