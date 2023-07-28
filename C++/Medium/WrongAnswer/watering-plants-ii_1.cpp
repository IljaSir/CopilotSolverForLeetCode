class Solution {
public:
    int minimumRefill(vector<int>& plants, int capacityA, int capacityB) {
        
        int n = plants.size();
        int i = 0, j = n - 1;
        int a = capacityA, b = capacityB;
        int res = 0;
        while (i <= j) {
            if (a >= plants[i] && b >= plants[j]) {
                if (plants[i] < plants[j]) {
                    a -= plants[i];
                    ++i;
                } else if (plants[i] > plants[j]) {
                    b -= plants[j];
                    --j;
                } else {
                    a -= plants[i];
                    ++i;
                }
            } else if (a >= plants[i]) {
                a -= plants[i];
                ++i;
            } else if (b >= plants[j]) {
                b -= plants[j];
                --j;
            } else {
                a = capacityA;
                b = capacityB;
                ++res;
            }
        }
        return res;
    }
};