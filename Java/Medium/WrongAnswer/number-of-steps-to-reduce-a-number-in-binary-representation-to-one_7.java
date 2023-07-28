class Solution {
    public int numSteps(String s) {
        
        int steps = 0;
        char[] arr = s.toCharArray();
        int len = arr.length;
        int i = len - 1;
        while (i > 0) {
            if (arr[i] == '0') {
                i--;
            } else {
                int j = i;
                while (j >= 0 && arr[j] == '1') {
                    arr[j] = '0';
                    j--;
                }
                if (j == -1) {
                    arr = new char[len + 1];
                    arr[0] = '1';
                    for (int k = 1; k < len + 1; k++) {
                        arr[k] = '0';
                    }
                    i = len;
                } else {
                    arr[j] = '1';
                    i = j;
                }
            }
            steps++;
        }
        return steps;
    }
}