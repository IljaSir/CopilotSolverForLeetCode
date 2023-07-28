class Solution {
public:
    int minFlips(string target) {
        
        int count = 0;
        int n = target.size();
        bool prev = false;
        for(int i = 0; i < n; i++) {
            if(target[i] == '1' && !prev) {
                count++;
                prev = true;
            }
            else if(target[i] == '0' && prev) {
                count++;
                prev = false;
            }
        }
        return count;
    }
};