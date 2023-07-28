class Solution {
public:
    int findLucky(vector<int>& arr) {
        
        int res = -1;
        for (int i = 1; i <= 500; ++i) {
            int cnt = 0;
            for (auto x : arr) {
                if (x == i) ++cnt;
            }
            if (cnt == i) res = max(res, i);
        }
        return res;
    }
};