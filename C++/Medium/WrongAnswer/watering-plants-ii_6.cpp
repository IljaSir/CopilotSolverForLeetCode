class Solution {
public:
    int minimumRefill(vector<int>& plants, int capacityA, int capacityB) {
        
        int n = plants.size();
        int i = 0, j = n - 1;
        int res = 0;
        int a = 0, b = 0;
        while (i < j) {
            if (a < plants[i]) {
                a = capacityA;
                ++res;
            }
            if (b < plants[j]) {
                b = capacityB;
                ++res;
            }
            a -= plants[i];
            b -= plants[j];
            ++i;
            --j;
        }
        if (i == j) {
            if (a + b < plants[i]) {
                res += 2;
            } else if (a < plants[i] || b < plants[i]) {
                ++res;
            }
        }
        return res;
    }
};