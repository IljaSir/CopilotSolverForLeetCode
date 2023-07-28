class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        
        int volume = length * width * height;
        if (volume >= Math.pow(10, 9) || length >= Math.pow(10, 4) || width >= Math.pow(10, 4) || height >= Math.pow(10, 4)) {
            if (mass >= 100) {
                return "Both";
            }
            return "Bulky";
        } else if (mass >= 100) {
            return "Heavy";
        }
        return "Neither";
    }
}