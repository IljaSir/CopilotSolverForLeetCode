class Solution {
public:
    int maxConsecutive(int bottom, int top, vector<int>& special) {
        
        int res = 0;
        sort(special.begin(), special.end());
        int last = bottom - 1;
        for (int i = 0; i < special.size(); ++i) {
            res = max(res, special[i] - last - 1);
            last = special[i];
        }
        res = max(res, top - last);
        return res;
    }
};