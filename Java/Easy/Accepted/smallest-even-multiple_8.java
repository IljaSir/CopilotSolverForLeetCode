class Solution {
    public int smallestEvenMultiple(int n) {
        
        int a = 2;
        while(a % n != 0){
            a += 2;
        }
        return a;
    }
}