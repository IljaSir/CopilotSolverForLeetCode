class Solution {
    public int largestInteger(int num) {
        
        char[] arr = String.valueOf(num).toCharArray();
        int[] even = new int[10];
        int[] odd = new int[10];
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] - '0') % 2 == 0) {
                even[arr[i] - '0']++;
            } else {
                odd[arr[i] - '0']++;
            }
        }
        int i = 0;
        int j = 1;
        while (i < arr.length) {
            if (arr[i] % 2 == 0) {
                while (j < 10) {
                    if (even[j] > 0) {
                        arr[i] = (char) (j + '0');
                        even[j]--;
                        break;
                    }
                    j += 2;
                }
            } else {
                while (j < 10) {
                    if (odd[j] > 0) {
                        arr[i] = (char) (j + '0');
                        odd[j]--;
                        break;
                    }
                    j += 2;
                }
            }
            if (j == 10) {
                break;
            }
            i++;
        }
        return Integer.valueOf(new String(arr));
    }
}