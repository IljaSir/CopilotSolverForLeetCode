class Solution {
    public int[] closestPrimes(int left, int right) {
        
        int[] result = new int[2];
        int min = Integer.MAX_VALUE;
        for(int i = left; i <= right; i++) {
            if(isPrime(i)) {
                int diff = 0;
                int j = i - 1;
                while(j >= left) {
                    if(isPrime(j)) {
                        diff = i - j;
                        break;
                    }
                    j--;
                }
                j = i + 1;
                while(j <= right) {
                    if(isPrime(j)) {
                        if(diff == 0) {
                            diff = j - i;
                        } else {
                            diff = Math.min(diff, j - i);
                        }
                        break;
                    }
                    j++;
                }
                if(diff < min) {
                    min = diff;
                    result[0] = j;
                    result[1] = i;
                }
            }
        }
        if(min == Integer.MAX_VALUE) {
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }
    
    public boolean isPrime(int n) {
        if(n <= 1) {
            return false;
        }
        if(n == 2 || n == 3) {
            return true;
        }
        if(n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for(int i = 5; i * i <= n; i += 6) {
            if(n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}