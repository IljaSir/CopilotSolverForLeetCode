class Solution {
public:
    int rotatedDigits(int n) {
        
        int count = 0;
        for(int i=1; i<=n; i++){
            if(isGood(i))
                count++;
        }
        return count;
    }
    
    bool isGood(int n){
        bool flag = false;
        while(n > 0){
            if(n%10 == 3 || n%10 == 4 || n%10 == 7)
                return false;
            if(n%10 == 2 || n%10 == 5 || n%10 == 6 || n%10 == 9)
                flag = true;
            n = n/10;
        }
        return flag;
    }
};