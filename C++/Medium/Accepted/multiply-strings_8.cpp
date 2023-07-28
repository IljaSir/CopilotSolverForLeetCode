class Solution {
public:
    string multiply(string num1, string num2) {
        
        int n1 = num1.size();
        int n2 = num2.size();
        string res(n1+n2, '0');
        for(int i = n1-1; i >= 0; i--) {
            for(int j = n2-1; j >= 0; j--) {
                int mul = (num1[i] - '0') * (num2[j] - '0');
                int sum = mul + (res[i+j+1] - '0');
                res[i+j+1] = sum % 10 + '0';
                res[i+j] += sum / 10;
            }
        }
        int i = 0;
        while(i < res.size() && res[i] == '0') i++;
        if(i == res.size()) return "0";
        return res.substr(i);
    }
};