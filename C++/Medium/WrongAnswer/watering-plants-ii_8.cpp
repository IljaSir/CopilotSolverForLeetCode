class Solution {
public:
    int minimumRefill(vector<int>& plants, int capacityA, int capacityB) {
        
        int n = plants.size();
        int i = 0, j = n-1;
        int refills = 0;
        int a = capacityA, b = capacityB;
        while (i <= j) {
            if (a < plants[i]) {
                refills++;
                a = capacityA;
            }
            if (b < plants[j]) {
                refills++;
                b = capacityB;
            }
            if (a >= plants[i]) {
                a -= plants[i];
                i++;
            }
            if (b >= plants[j]) {
                b -= plants[j];
                j--;
            }
        }
        return refills;
    }
};