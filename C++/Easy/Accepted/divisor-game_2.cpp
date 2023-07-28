class Solution {
public:
    bool divisorGame(int n) {
        
        // 1. Alice wins if n is even
        // 2. Alice loses if n is odd
        return n % 2 == 0;
    }
};