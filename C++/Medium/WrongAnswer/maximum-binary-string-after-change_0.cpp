class Solution {
public:
    string maximumBinaryString(string binary) {
        
        int cnt = 0, n = binary.size();
        for (int i = 0; i < n; i++) {
            if (binary[i] == '0') cnt++;
        }
        if (cnt == 0) return binary;
        string ans = "";
        for (int i = 0; i < n; i++) {
            if (i < cnt - 1) ans += "1";
            else if (i == cnt - 1) ans += "0";
            else ans += "1";
        }
        return ans;
    }
};