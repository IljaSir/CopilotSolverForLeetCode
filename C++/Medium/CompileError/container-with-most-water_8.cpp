class Solution {
public:
    int maxArea(vector<int>& height) {
        
        string result = "";
        int i = 0;
        while(num > 0){
            int digit = num % 10;
            string digitRoman = getRoman(digit, i);
            result = digitRoman + result;
            num = num / 10;
            i++;
        }
        return result;
    }
    
    string getRoman(int digit, int index){
        string result = "";
        if(index == 0){
            result = getRoman(digit, "I", "V", "X");
        }else if(index == 1){
            result = getRoman(digit, "X", "L", "C");
        }else if(index == 2){
            result = getRoman(digit, "C", "D", "M");
        }else if(index == 3){
            result = getRoman(digit, "M", "M", "M");
        }
        return result;
    }
    
    string getRoman(int digit, string one, string five, string ten){
        string result = "";
        if(digit == 0){
            result = "";
        }else if(digit == 1){
            result = one;
        }else if(digit == 2){
            result = one + one;
        }else if(digit == 3){
            result = one + one + one;
        }else if(digit == 4){
            result = one + five;
        }else if(digit == 5){
            result = five;
        }else if(digit == 6){
            result = five + one;
        }else if(digit == 7){
            result = five + one + one;
        }else if(digit == 8){
            result = five + one + one + one;
        }else if(digit == 9){
            result = one + ten;
        }
        return result;
    }
};