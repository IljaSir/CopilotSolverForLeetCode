class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        int gcd = gcd(divisor1, divisor2);
        int lcm = divisor1 * divisor2 / gcd;
        int[] arr1 = new int[uniqueCnt1];
        int[] arr2 = new int[uniqueCnt2];
        int i = 0, j = 0;
        int num = 1;
        while (i < uniqueCnt1 && j < uniqueCnt2) {
            if (num % divisor1 == 0 && num % divisor2 == 0) {
                num++;
                continue;
            }
            if (num % divisor1 == 0) {
                arr1[i++] = num;
            } else if (num % divisor2 == 0) {
                arr2[j++] = num;
            }
            num++;
        }
        while (i < uniqueCnt1) {
            arr1[i++] = num;
            num++;
        }
        while (j < uniqueCnt2) {
            arr2[j++] = num;
            num++;
        }
        return Math.max(arr1[uniqueCnt1 - 1], arr2[uniqueCnt2 - 1]);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}