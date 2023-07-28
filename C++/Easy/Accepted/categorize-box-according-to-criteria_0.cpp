class Solution {
public:
    string categorizeBox(int length, int width, int height, int mass) {
        
        if (length >= 10000 || width >= 10000 || height >= 10000 || (long long)length * width * height >= 1000000000) {
            if (mass >= 100) {
                return "Both";
            }
            return "Bulky";
        }
        if (mass >= 100) {
            return "Heavy";
        }
        return "Neither";
    }
};