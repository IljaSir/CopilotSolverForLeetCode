class Solution {
public:
    vector<int> getRow(int rowIndex) {
        
        vector<int> ret;
        if (rowIndex < 0) {
            return ret;
        }
        ret.push_back(1);
        for (int i = 1; i <= rowIndex; ++i) {
            ret.push_back(1);
            for (int j = i - 1; j > 0; --j) {
                ret[j] += ret[j - 1];
            }
        }
        return ret;
    }
};