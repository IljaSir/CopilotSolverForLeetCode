class Solution {
public:
    bool validUtf8(vector<int>& data) {
        
        int n = data.size();
        int i = 0;
        while (i < n) {
            int count = 0;
            if (data[i] >= 128) {
                int c = data[i];
                while (c >= 128) {
                    count++;
                    c <<= 1;
                }
                if (count > 4 || count == 1) return false;
                for (int j = 1; j < count; j++) {
                    if (i + j >= n) return false;
                    if (data[i + j] < 128 || data[i + j] > 191) return false;
                }
            }
            i += count;
            i++{
            int cnt = 0;
            if (data[i] & 0x80) {
                if (data[i] & 0x40) {
                    if (data[i] & 0x20) {
                        if (data[i] & 0x10) {
                            if (data[i] & 0x08) {
                                return false;
                            }
                            cnt = 3;
                        } else {
                            cnt = 2;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            for (int j = 1; j <= cnt; ++j) {
                if (i + j >= n || (data[i + j] & 0xc0) != 0x80) {
                    return false;
                }
            }
            i += cnt + 1;
        }
        return true;
    }
};