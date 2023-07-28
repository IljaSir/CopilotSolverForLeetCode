class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        
        long[] result = new long[queries.length];
        int index = 0;
        for (int query : queries) {
            int length = intLength;
            long firstHalf = 0;
            long secondHalf = 0;
            long palindrom = 0;
            if (length % 2 == 0) {
                firstHalf = (long) Math.pow(10, length/2) - 1;
                secondHalf = firstHalf;
            } else {
                firstHalf = (long) Math.pow(10, length/2) - 1;
                secondHalf = firstHalf / 10;
            }
            long step = 0;
            while (step < query) {
                if (secondHalf == 0) {
                    firstHalf--;
                    secondHalf = firstHalf;
                    if (length % 2 == 0) {
                        palindrom = firstHalf * (long) Math.pow(10, length/2) + secondHalf;
                    } else {
                        palindrom = firstHalf * (long) Math.pow(10, length/2 + 1) + secondHalf;
                    }
                } else {
                    secondHalf--;
                    if (length % 2 == 0) {
                        palindrom = firstHalf * (long) Math.pow(10, length/2) + secondHalf;
                    } else {
                        palindrom = firstHalf * (long) Math.pow(10, length/2 + 1) + secondHalf;
                    }
                }
                step++;
            }
            result[index++] = palindrom;
        }
        return result;
    }
}