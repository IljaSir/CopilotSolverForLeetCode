class Solution {
public:
    int minimumRefill(vector<int>& plants, int capacityA, int capacityB) {
        
        int n = plants.size();
        int i = 0, j = n - 1;
        int ca = 0, cb = 0;
        int res = 0;
        while (i <= j) {
            if (ca < plants[i]) {
                ca = capacityA;
                ++res;
            }
            if (cb < plants[j]) {
                cb = capacityB;
                ++res;
            }
            ca -= plants[i];
            cb -= plants[j];
            ++i;
            --j;
        }
        if (ca > 0) --res;
        if (cb > 0) --res;
        return res;
    }
};