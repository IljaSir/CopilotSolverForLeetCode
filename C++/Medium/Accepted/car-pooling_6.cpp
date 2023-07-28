class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        
        vector<int> capacityChange(1001);
        for (auto& trip : trips) {
            capacityChange[trip[1]] += trip[0];
            capacityChange[trip[2]] -= trip[0];
        }
        int currentCapacity = 0;
        for (auto change : capacityChange) {
            currentCapacity += change;
            if (currentCapacity > capacity) return false;
        }
        return true;
    }
};