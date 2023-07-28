class Solution {
public:
    string abbreviateProduct(int left, int right) {
        
        long long int product = 1;
        for(int i = left; i <= right; i++){
            product *= i;
        }
        string s = to_string(product);
        int n = s.length();
        int i = n - 1;
        while(i >= 0 && s[i] == '0'){
            i--;
        }
        int count = n - i - 1;
        string pre = s.substr(0, 5);
        string suf = s.substr(n - 5, 5);
        string e = "e" + to_string(count);
        return pre + "..." + suf + e;
    }
};