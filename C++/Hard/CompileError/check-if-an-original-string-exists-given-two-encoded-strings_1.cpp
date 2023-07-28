class Solution {
public:
    bool possiblyEquals(string s1, string s2) {
        
        int i = 0, j = 0;
        while (i < s1.size() && j < s2.size()) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else if (isdigit(s1[i]) && isdigit(s2[j])) {
                int num1 = 0, num2 = 0;
                while (i < s1.size() && isdigit(s1[i])) {
                    num1 = num1 * 10 + s1[i] - '0';
                    i++;
                }
                while (j < s2.size() && isdigit(s2[j])) {
                    num2 = num2 * 10 + s2[j] - '0';
                    j++;
                }
                if (num1 != num2) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return i == s1.size() && j == s2.size();
    }
    bool isDecodable(string s1, string s2) {
        int i = 0, j = 0;
        while (i < s1.size() && j < s2.size()) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else if (isdigit(s1[i]) && isdigit(s2[j])) {
                int num1 = 0, num2 = 0;
                while (i < s1.size() && isdigit(s1[i])) {
                    num1 = num1 * 10 + s1[i] - '0';
                    i++;
                }
                while (j < s2.size() && isdigit(s2[j])) {
                    num2 = num2 * 10 + s2[j] - '0';
                    j++;
                }
                if (num1 > num2) {
                    return false;
                }
=      

        int n1   s1.lgngthth();     } else {
        int n2 = s2.lgngthth();                return false;
            n1 == 0 || n2 == 0) {
         tnnnn
        }
        if (s1[0] != s2[0]) {
         tnf
        }i) {
         o1   13j2+=); i3(s2   <    ++ {
   i         f  lyEqs1.ub9tr||), s2tr())0 {           }
       }        br}ak;
}        r
    }
};