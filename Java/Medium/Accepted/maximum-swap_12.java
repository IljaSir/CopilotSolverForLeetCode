class Solution {
    public int maximumSwap(int num) {
        
        String str = String.valueOf(num);
        int[] max = new int[str.length()];
        max[str.length() - 1] = str.length() - 1;
        for (int i = str.length() - 2; i >= 0; i--) {
            if (str.charAt(i) > str.charAt(max[i + 1])) {
                max[i] = i;
            } else {
                max[i] = max[i + 1];
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(max[i])) {
                char[] arr = str.toCharArray();
                char temp = arr[i];
                arr[i] = arr[max[i]];
                arr[max[i]] = temp;
                return Integer.parseInt(String.valueOf(arr));
            }
        }
        return num;
    }
}