class Solution {
public:
    int minimumRefill(vector<int>& plants, int capacityA, int capacityB) {
        
        int n = plants.size();
        int a = 0, b = n - 1;
        int cnt = 0;
        int ca = 0, cb = 0;
        while (a <= b) {
            if (a == b) {
                if (ca + cb < plants[a]) {
                    ++cnt;
                }
                break;
            }
            if (ca < plants[a]) {
                ca = capacityA;
                ++cnt;
            }
            if (cb < plants[b]) {
                cb = capacityB;
                ++cnt;
            }
            ca -= plants[a];
            cb -= plants[b];
            ++a;
            --b;
        }
        return cnt;
    }
};