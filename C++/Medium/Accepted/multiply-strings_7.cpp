class Solution {
public:
    string multiply(string num1, string num2) {
        
        if (num1 == "0" || num2 == "0") {
            return "0";
        }
        int size1 = num1.size();
        int size2 = num2.size();
        vector<int> result(size1 + size2, 0);
        for (int i = size1 - 1; i >= 0; --i) {
            for (int j = size2 - 1; j >= 0; --j) {
                int num = (num1[i] - '0') * (num2[j] - '0');
                int sum = result[i + j + 1] + num;
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        string ans = "";
        for (int i = 0; i < size1 + size2; ++i) {
            if (i == 0 && result[i] == 0) {
                continue;
            }
            ans += result[i] + '0';
        }
        return ans;
    }
};