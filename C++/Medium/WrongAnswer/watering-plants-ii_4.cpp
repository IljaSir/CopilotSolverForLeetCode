class Solution {
public:
    int minimumRefill(vector<int>& plants, int capacityA, int capacityB) {
        
        int n = plants.size();
        int i = 0, j = n - 1;
        int count = 0;
        int waterA = 0, waterB = 0;
        while (i <= j) {
            if (waterA < plants[i]) {
                waterA = capacityA;
                ++count;
            }
            waterA -= plants[i];
            ++i;
            if (i > j) {
                break;
            }
            if (waterB < plants[j]) {
                waterB = capacityB;
                ++count;
            }
            waterB -= plants[j];
            --j;
        }
        return count;
    }
};