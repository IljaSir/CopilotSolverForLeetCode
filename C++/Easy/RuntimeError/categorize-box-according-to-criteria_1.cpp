class Solution {
public:
    string categorizeBox(int length, int width, int height, int mass) {
        
        int volume = length * width * height;
        if (volume >= 1000000000 || length >= 10000 || width >= 10000 || height >= 10000) {
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