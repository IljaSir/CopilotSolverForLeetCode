class Solution {
public:
    int minimumRefill(vector<int>& plants, int capacityA, int capacityB) {
        
        int i = 0, j = plants.size() - 1;
        int a = capacityA, b = capacityB;
        int ret = 0;
        while (i <= j) {
            if (a >= plants[i] && b >= plants[j]) {
                if (a >= b) {
                    a -= plants[i++];
                } else {
                    b -= plants[j--];
                }
            } else if (a >= plants[i]) {
                a -= plants[i++];
            } else if (b >= plants[j]) {
                b -= plants[j--];
            } else {
                a = capacityA;
                b = capacityB;
                ++ret;
            }
        }
        return ret;
    }
};