class Solution {
public:
    int minimumRefill(vector<int>& plants, int capacityA, int capacityB) {
        
        int n = plants.size();
        int i = 0, j = n - 1;
        int a = 0, b = 0;
        int res = 0;
        while (i <= j) {
            if (a + plants[i] <= capacityA) {
                a += plants[i];
                i++;
            } else if (b + plants[j] <= capacityB) {
                b += plants[j];
                j--;
            } else {
                res++;
                a = 0;
                b = 0;
            }
        }
        return res;
    }
};