class Solution {
public:
    int superPow(int a, vector<int>& b) {
        
        int power = 0;
        for(int i = 0; i < b.size(); ++i){
            power = (power * 10 + b[i]) % 1140;
        }
        if(power == 0) power += 1440;
        return fastPow(a, power, 1337);
    }
};