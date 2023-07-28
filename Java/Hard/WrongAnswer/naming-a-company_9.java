class Solution {
    public long distinctNames(String[] ideas) {
        
        if (ideas.length == 0) {
            return 0;
        }
        int len = ideas.length;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int val = 0;
            for (int j = 0; j < ideas[i].length(); j++) {
                val += ideas[i].charAt(j) - 'a' + 1;
            }
            arr[i] = val;
        }
        Arrays.sort(arr);
        long res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int val = arr[i] + arr[j];
                int left = j + 1;
                int right = len - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (arr[mid] == val) {
                        res++;
                        break;
                    } else if (arr[mid] > val) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return res;
    }
}