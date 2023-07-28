class Solution {
public:
    bool canReorderDoubled(vector<int>& arr) {
        
        map<int, int> count;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }
        for (auto& p : count) {
            int x = p.first;
            int c = p.second;
            if (x < 0) {
                if (x % 2 != 0) {
                    return false;
                }
                if (count[x / 2] < c) {
                    return false;
                }
                count[x / 2] -= c;
            } else {
                if (count[2 * x] < c) {
                    return false;
                }
                count[2 * x] -= c;
            }
        }
        return true;
    }
};