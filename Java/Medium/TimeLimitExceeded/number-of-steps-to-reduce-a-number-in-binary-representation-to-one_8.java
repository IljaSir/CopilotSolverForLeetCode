class Solution {
    public int numSteps(String s) {
        
        int count = 0;
        char[] arr = s.toCharArray();
        int n = arr.length;
        while (n > 1) {
            count++;
            if (arr[n - 1] == '0') {
                n--;
            } else {
                int i = n - 1;
                while (i >= 0 && arr[i] == '1') {
                    arr[i] = '0';
                    i--;
                }
                if (i == -1) {
                    n++;
                    arr = new char[n];
                    arr[0] = '1';
                } else {
                    arr[i] = '1';
                }
            }
        }
        return count;
    }
}