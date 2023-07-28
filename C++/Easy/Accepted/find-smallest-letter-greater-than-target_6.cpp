class Solution {
public:
    char nextGreatestLetter(vector<char>& letters, char target) {
        
        int n = letters.size();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return letters[l] > target ? letters[l] : letters[0];
    }
};