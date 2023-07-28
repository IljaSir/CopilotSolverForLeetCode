class Solution {
public:
    bool validUtf8(vector<int>& data) {
        
        int n = data.size();
        int i = 0;
        while (i < n) {
            int cnt = 0;
            if (data[i] >> 7 == 0) {
                i++;
                continue;
            }
            if (data[i] >> 5 == 6) {
                cnt = 1;
            } else if (data[i] >> 4 == 14) {
                cnt = 2;
            } else if (data[i] >> 3 == 30) {
                cnt = 3;
            } else {
                return false;
            }
            while (cnt > 0) {
                i++;
                if (i >= n || data[i] >> 6 != 2) {
                    return false;
                }
                cnt--;
            }
            i++;
        }
        return true;
    }
};