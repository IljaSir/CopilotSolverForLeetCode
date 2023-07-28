class Solution {
public:
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        
        int ans = 0;
        sort(boxTypes.begin(), boxTypes.end(), [](vector<int>& a, vector<int>& b) {
            return a[1] > b[1];
        });
        for (vector<int>& box : boxTypes) {
            int num = min(box[0], truckSize);
            ans += num * box[1];
            truckSize -= num;
            if (truckSize == 0) break;
        }
        return ans;
    }
};