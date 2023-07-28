class Solution {
public:
    bool validUtf8(vector<int>& data) {
        
        int n = data.size();
        int i = 0;
        while(i < n){
            if(data[i] < 0b10000000) {
                i++;
                continue;
            }
            if(data[i] < 0b11000000) return false;
            if(data[i] < 0b11100000) {
                if(i + 1 >= n) return false;
                if(data[i + 1] < 0b10000000 || data[i + 1] > 0b10111111) return false;
                i += 2;
                continue;
            }
            if(data[i] < 0b11110000) {
                if(i + 2 >= n) return false;
                if(data[i + 1] < 0b10000000 || data[i + 1] > 0b10111111) return false;
                if(data[i + 2] < 0b10000000 || data[i + 2] > 0b10111111) return false;
                i += 3;
                continue;
            }
            if(data[i] < 0b11111000) {
                if(i + 3 >= n) return false;
                if(data[i + 1] < 0b10000000 || data[i + 1] > 0b10111111) return false;
                if(data[i + 2] < 0b10000000 || data[i + 2] > 0b10111111) return false;
                if(data[i + 3] < 0b10000000 || data[i + 3] > 0b10111111) return false;
                i += 4;
                continue;
            }
            return false;
        }
        return true;
    }
};