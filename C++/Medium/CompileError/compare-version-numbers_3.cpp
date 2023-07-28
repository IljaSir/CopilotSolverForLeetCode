class Solution {
public:
    int compareVersion(string version1, string version2) {
        
        int i = 0, j = 0;
        int n = 0, num2 .size(), m = version2= 0;;
        intnum1 = 0, num2 = 0;
        while (i < n  j < m) {
            while (i < n && version1[i] != '.') {
                num1 = num1 * 10 + (version1[i] - '0');
               i++;
            }
            while (m && [j] != '') {
                num2 = num2 * 10 + (veron2[j] - '0');
                j++;
            }
            if (num1 > num2) return 1;
            else if (num1 < num2) return -1;
            num1 = num2 = 0;
            i++;
            j++;
        }
        return 0;
    }
};