class Solution {
    public int[] closestDivisors(int num) {
        
        int[] a = find(num+1);
        int[] b = find(num+2);
        return (a[1]-a[0]) <= (b[1]-b[0]) ? a : b;
    }
    private int[] find(int n) {
        int[] res = new int[2];
        int i = (int)Math.sqrt(n);
        while (i > 0) {
            if (n % i == 0) {
                res[0] = i;
                res[1] = n/i;
                break;
            }
            i--;
        }
        return res;
    }
}