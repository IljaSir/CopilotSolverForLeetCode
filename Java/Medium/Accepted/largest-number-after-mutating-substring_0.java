class Solution {
    public String maximumNumber(String num, int[] change) {
        
        char[] arr = num.toCharArray();
        boolean changed = false;
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] - '0';
            if (digit < change[digit]) {
                arr[i] = (char) (change[digit] + '0');
                changed = true;
            } else if (digit > change[digit] && changed) {
                break;
            }
        }
        return new String(arr);
    }
}