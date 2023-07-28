class Solution {
public:
    int minimumRefill(vector<int>& plants, int capacityA, int capacityB) {
        
        int n = plants.size();
        int i = 0, j = n - 1;
        int cnt = 0;
        int a = capacityA, b = capacityB;
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
                ++cnt;
            }
        }
        return cnt;
    }
};