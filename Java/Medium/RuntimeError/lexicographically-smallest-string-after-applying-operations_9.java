class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        
        char[] arr = s.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            arr[i] -= '0';
        }
        char[] res = Arrays.copyOf(arr, n);
        dfs(arr, res, 0, a, b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(res[i]);
        }
        return sb.toString();
    }
    private void dfs(char[] arr, char[] res, int start, int a, int b) {
        if (start == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < res[i]) {
                    System.arraycopy(arr, 0, res, 0, arr.length);
                    break;
                } else if (arr[i] > res[i]) {
                    break;
                }
            }
            return;
        }
        dfs(arr, res, start + 1, a, b);
        if (start % 2 == 1) {
            arr[start] = (char) ((arr[start] + a) % 10);
        }
        dfs(arr, res, start + 1, a, b);
        if (start % 2 == 1) {
            arr[start] = (char) ((arr[start] - a + 10) % 10);
        }
        char temp = arr[arr.length - 1];
        for (int i = arr.length - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
        dfs(arr, res, start, a, b);
        temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }
}