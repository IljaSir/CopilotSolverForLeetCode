class Solution {
public:
    bool strongPasswordCheckerII(string password) {
        
        int n = password.size();
        bool hasUpper = false;
        bool hasLower = false;
        bool hasDigit = false;
        bool hasSpecial = false;
        for (char c: password) {
            if (c >= 'A' && c <= 'Z') hasUpper = true;
            else if (c >= 'a' && c <= 'z') hasLower = true;
            else if (c >= '0' && c <= '9') hasDigit = true;
            else hasSpecial = true;
        }
        int missingType = 4 - (hasUpper + hasLower + hasDigit + hasSpecial);
        if (n < 6) {
            return missingType <= 6 - n;
        } else if (n <= 20) {
            return missingType == 0;
        } else {
            int deleteCount = n - 20;
            int replaceCount = 0;
            int oneCount = 0;
            int twoCount = 0;
            for (int i = 0, j = 0; i < n; i = j) {
                while (j < n && password[i] == password[j]) j++;
                int length = j - i;
                if (length >= 3) {
                    replaceCount += length / 3;
                    if (length % 3 == 0) oneCount++;
                    else if (length % 3 == 1) twoCount++;
                }
            }
            if (deleteCount >= replaceCount) {
                deleteCount -= replaceCount;
            } else {
                replaceCount -= deleteCount;
                deleteCount = 0;
                oneCount += replaceCount;
            }
            if (deleteCount > 0) {
                oneCount += deleteCount / 2;
                twoCount += (deleteCount % 2) * 2;
            }
            return missingType == 0 && oneCount <= 2 && twoCount <= 1;
        }
    }
};