class Solution {
    public int largestInteger(int num) {
        
        String numStr = Integer.toString(num);
        int[] odd = new int[numStr.length()];
        int[] even = new int[numStr.length()];
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            if (digit % 2 == 0) {
                even[evenIndex++] = digit;
            } else {
                odd[oddIndex++] = digit;
            }
        }
        Arrays.sort(even, 0, evenIndex);
        Arrays.sort(odd, 0, oddIndex);
        int[] result = new int[numStr.length()];
        int resultIndex = 0;
        int oddIndexCopy = oddIndex;
        int evenIndexCopy = evenIndex;
        while (oddIndexCopy > 0 || evenIndexCopy > 0) {
            if (oddIndexCopy > 0 && evenIndexCopy > 0) {
                if (even[evenIndex - evenIndexCopy] > odd[oddIndex - oddIndexCopy]) {
                    result[resultIndex++] = even[evenIndex - evenIndexCopy];
                    evenIndexCopy--;
                } else {
                    result[resultIndex++] = odd[oddIndex - oddIndexCopy];
                    oddIndexCopy--;
                }
            } else if (oddIndexCopy > 0) {
                result[resultIndex++] = odd[oddIndex - oddIndexCopy];
                oddIndexCopy--;
            } else {
                result[resultIndex++] = even[evenIndex - evenIndexCopy];
                evenIndexCopy--;
            }
        }
        int resultInt = 0;
        for (int i = 0; i < result.length; i++) {
            resultInt += result[i] * Math.pow(10, result.length - i - 1);
        }
        return resultInt;
    }
}