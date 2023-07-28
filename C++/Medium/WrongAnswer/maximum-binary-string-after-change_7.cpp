class Solution {
public:
    string maximumBinaryString(string binary) {
        
        int n = binary.size();
        int cnt = 0;
        int i = 0;
        for (; i < n; i++) {
            if (binary[i] == '1') {
                cnt++;
            } else {
                break;
            }
        }
        if (i == n) {
            return binary;
        }
        int j = n - 1;
        while (binary[j] == '0') {
            j--;
        }
        int cnt2 = n - j - 1;
        return string(cnt, '1') + string(n - cnt - cnt2, '0') + string(cnt2, '1');
    }
};