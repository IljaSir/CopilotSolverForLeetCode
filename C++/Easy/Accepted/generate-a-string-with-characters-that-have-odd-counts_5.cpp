class Solution {
public:
    string generateTheString(int n) {
        
        string result;
        if (n % 2 == 0) {
            result = "a";
            for (int i = 1; i < n; i++) {
                result += "b";
            }
        } else {
            for (int i = 0; i < n; i++) {
                result += "a";
            }
        }
        return result;
    }
};