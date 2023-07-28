class Solution {
public:
    string maximumBinaryString(string binary) {
        
        int n = binary.size();
        int i = 0;
        while (i < n && binary[i] == '1') {
            i++;
        }
        int cnt = 0;
        while (i < n) {
            cnt += binary[i] == '0';
            i++;
        }
        string ans = "";
        for (int i = 0; i < n - cnt - 1; i++) {
            ans += '1';
        }
        ans += '0';
        for (int i = 0; i < cnt; i++) {
            ans += '1';
        }
        return ans;
    }
};