class Solution {
public:
    string intToRoman(int num) {
        
        string result;
        string romanSymbols[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int romanValues[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int i = 0;
        while(num){
            int times = num / romanValues[i];
            num %= romanValues[i];
            while(times--){
                result += romanSymbols[i];
            }
            i++;
        }
        return result;
    }
};