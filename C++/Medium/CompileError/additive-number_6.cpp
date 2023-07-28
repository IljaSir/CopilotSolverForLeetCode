class Solution {
public:
    bool isAdditiveNumber(string num) {
        
        if(num.size() < 3) return false;
        for(int i = 1; i <= num.size() / 2; i++) {
            for(int j = 1; j <= (num.size() - i) / 2; j++) {
                if(isAdditive(num.substr(0, i), num.substr(i, j), num.substr(i + j))) {
                    return true;
                }
            }
        }
        return false;
    }
};