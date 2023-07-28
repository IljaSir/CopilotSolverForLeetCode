class Solution {
public:
    bool queryString(string s, int n) {
        
        for (int i = 1; i <= n; i++)
        {
            string binary = "";
            int num = i;
            while (num > 0)
            {
                binary = to_string(num % 2) + binary;
                num /= 2;
            }
            if (s.find(binary) == string::npos)
                return false;
        }
        return true;
    }
};