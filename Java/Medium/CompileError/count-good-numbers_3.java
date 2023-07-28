class Solution {
    public int countGoodNumbers(long n) {
        
        long even = n/2;
        long odd = (n+1)/2;
        return (int)((pow(5,even)*pow(4,odd))%1000000007);
    }
}