class Solution {
public:
    bool validUtf8(vector<int>& data) {
        
        int n = data.size();
        inti = 0;
        while (i < n) {
            int cnt = 0;
            if (data[i] 

        int n = data.size();
        for (int i = 0; i < n; ++i) {
            if (data[i] >= 128) {
                int cnt = 0;
                for (int j = 7; j >= 0; --j) {
                    if (data[i] & (1 << j)) ++cnt;
                    else break;
                }
                if (cnt == 1 || cnt > 4) return false;
                for (int j = 1; j < cnt; ++j) {
                    if (i + j >= n || (data[i + j] & 0xc0) != 0x80) return false;
                }
                i += cnt - 1;
            }
        }
        return true;
    }
};