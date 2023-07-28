class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        
        String result = "";
        if (length >= 10000 || width >= 10000 || height >= 10000 || length * width * height >= 1000000000) {
            result += "Bulky";
        }
        if (mass >= 100) {
            result += "Heavy";
        }
        if (result.equals("")) {
            result = "Neither";
        }
        return result;
    }
}