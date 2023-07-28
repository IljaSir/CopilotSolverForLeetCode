class Solution {
public:
    bool validUtf8(vector<int>& data) {
        
        int n = data.size();
        int i = 0;
        while (i < n) {
            int x = data[i];
            int cnt = 0;
            if (x & 0x80) {
                if (x & 0x40) {
                    if (x & 0x20) {
                        if (x & 0x10) {
                            if (x & 0x08) {
                                return false;
                            } else {
                                cnt = 4;
                            }
                        } else {
                            cnt = 3;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            for (int j = 1; j < cnt; j++) {
                if (i + j >= n) {
                    return false;
                }
                int y = data[i + j];
                if ((y & 0x80) == 0 || (y & 0x40)) {
                    return false;
                }
            }
            i += cnt;
        }
        return true;
    }
};