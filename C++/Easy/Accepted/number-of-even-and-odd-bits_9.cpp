class Solution {
public:
    vector<int> evenOddBit(int n) {
        
        vector<int> result(2, 0);
        for(int i = 0; i < 10; ++i){
            if(n & (1 << i)){
                if(i % 2){
                    ++result[1];
                }else{
                    ++result[0];
                }
            }
        }
        return result;
    }
};