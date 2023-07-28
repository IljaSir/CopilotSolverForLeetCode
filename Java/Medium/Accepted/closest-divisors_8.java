class Solution {
    public int[] closestDivisors(int num) {
        
        int[] res = new int[2];
        int[] res1 = new int[2];
        int[] res2 = new int[2];
        
        int n1 = num + 1;
        int n2 = num + 2;
        
        int i = 1;
        while (i <= Math.sqrt(n1)) {
            if (n1 % i == 0) {
                res1[0] = i;
                res1[1] = n1 / i;
            }
            i++;
        }
        i = 1;
        while (i <= Math.sqrt(n2)) {
            if (n2 % i == 0) {
                res2[0] = i;
                res2[1] = n2 / i;
            }
            i++;
        }
        
        if (Math.abs(res1[0] - res1[1]) < Math.abs(res2[0] - res2[1])) {
            return res1;
        } else {
            return res2;
        }
    }
}