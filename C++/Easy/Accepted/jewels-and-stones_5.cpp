class Solution {
public:
    int numJewelsInStones(string jewels, string stones) {
        
        int count = 0;
        for (auto stone: stones) {
            if (jewels.find(stone) != string::npos) {
                count++;
            }
        }
        return count;
    }
};