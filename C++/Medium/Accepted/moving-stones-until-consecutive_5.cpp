class Solution {
public:
    vector<int> numMovesStones(int a, int b, int c) {
        
        vector<int> v = {a, b, c};
        sort(v.begin(), v.end());
        int min = 0;
        if (v[1] - v[0] > 1) min++;
        if (v[2] - v[1] > 1) min++;
        if (min == 2 && v[1] - v[0] == 2) min = 1;
        if (min == 2 && v[2] - v[1] == 2) min = 1;
        int max = v[2] - v[0] - 2;
        return {min, max};
    }
};