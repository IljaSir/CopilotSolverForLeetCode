class Solution {
    public int largestInteger(int num) {
        
        String str = Integer.toString(num);
        int[] odd = new int[10];
        int[] even = new int[10];
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
            if (arr[i] % 2 == 0) {
                even[arr[i]]++;
            } else {
                odd[arr[i]]++;
            }
        }
        int[] oddCount = new int[10];
        int[] evenCount = new int[10];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCount[arr[i]]++;
                if (evenCount[arr[i]] <= even[arr[i]]) {
                    continue;
                }
                for (int j = 9; j > arr[i]; j -= 2) {
                    if (oddCount[j] < odd[j]) {
                        arr[i] = j;
                        oddCount[j]++;
                        break;
                    }
                }
            } else {
                oddCount[arr[i]]++;
                if (oddCount[arr[i]] <= odd[arr[i]]) {
                    continue;
                }
                for (int j = 8; j >= arr[i]; j -= 2) {
                    if (evenCount[j] < even[j]) {
                        arr[i] = j;
                        evenCount[j]++;
                        break;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res = res * 10 + arr[i];
        }
        return res;
    }
}