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
            i++;
        }
        return true;
    }
};