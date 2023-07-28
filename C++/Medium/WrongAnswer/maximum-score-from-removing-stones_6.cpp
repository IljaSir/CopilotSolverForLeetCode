class Solution {
public:
    int maximumScore(int a, int b, int c) {
        
        int res = 0;
        vector<int> v = {a, b, c};
        sort(v.begin(), v.end());
        while (v[0] + v[1] > 0) {
            if (v[2] > 0) {
                v[2]--;
                res++;
            }
            sort(v.begin(), v.end());
        }
        return res;
    }
};