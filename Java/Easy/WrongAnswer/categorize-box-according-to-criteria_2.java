class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        
        int volume = length * width * height;
        if (length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000) {
            if (mass >= 100) {
                return "Both";
            } else {
                return "Bulky";
            }
        } else {
            if (mass >= 100) {
                return "Heavy";
            } else {
                return "Neither";
            }
        }
    }
}