class Solution {
public:
    int minimumRefill(vector<int>& plants, int capacityA, int capacityB) {
        
        int n = plants.size();
        int a = 0, b = n - 1;
        int count = 0;
        while (a <= b) {
            int waterA = capacityA;
            int waterB = capacityB;
            while (a <= b && waterA >= plants[a]) {
                waterA -= plants[a];
                a++;
            }
            while (a <= b && waterB >= plants[b]) {
                waterB -= plants[b];
                b--;
            }
            if (a <= b) {
                count++;
            }
        }
        return count;
    }
};