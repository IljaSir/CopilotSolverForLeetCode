class Solution {
public:
    int maxArea(vector<int>& height) {
        
        string result;
        vector<string> roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        vector<int> value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < value.size(); i++) {
            while (num >= value[i]) {
                num -= value[i];
                result += roman[i];
            }
        }
        return result;
    }
};