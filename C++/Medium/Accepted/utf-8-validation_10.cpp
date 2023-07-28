class Solution {
public:
    bool validUtf8(vector<int>& data) {
        
        int n = data.size();
        int i = 0;
        while (i < n) {
            int byte = data[i];
            int count = 0;
            if (byte >> 7 == 0) {
                count = 1;
            } else if (byte >> 5 == 6) {
                count = 2;
            } else if (byte >> 4 == 14) {
                count = 3;
            } else if (byte >> 3 == 30) {
                count = 4;
            } else {
                return false;
            }
            for (int j = 1; j < count; ++j) {
                if (i + j >= n) {
                    return false;
                }
                if (data[i + j] >> 6 != 2) {
                    return false;
                }
            }
            i += count;
        }
        return true;
    }
};