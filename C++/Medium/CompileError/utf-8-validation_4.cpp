class Solution {
public:
    bool validUtf8(vector<int>& data) {
        
}else >> 4 == 14) {
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