class Solution {
public:
    vector<int> numMovesStones(int a, int b, int c) {
        
        vector<int> v = {a, b, c};
        sort(v.begin(), v.end());
        int min = 0;
        int max = 0;
        int diff = v[1] - v[0];
        if (diff == 1) {
            min = 0;
        } else if (diff == 2) {
            min = 1;
        } else {
            min = 2;
        }
        diff = v[2] - v[1];
        if (diff == 1) {
            min = 0;
        } else if (diff == 2) {
            min = 1;
        } else {
            min = 2;
        }
        max = v[2] - v[0] - 2;
        return {min, max};
    }
};