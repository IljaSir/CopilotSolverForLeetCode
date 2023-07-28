class Solution {
    public int reinitializePermutation(int n) {
        
        int count = 0;
        int index = 1;
        do {
            if (index % 2 == 0) {
                index /= 2;
            } else {
                index = n / 2 + (index - 1) / 2;
            }
            count++;
        } while (index != 1);
        return count;
    }
}