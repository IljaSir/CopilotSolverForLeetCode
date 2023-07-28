class Solution {
public:
    int twoEggDrop(int n) {
        
        int count = 0;
        int sum = 0;
        while(sum < n){
            count++;
            sum += count;
        }
        return count;
    }
};