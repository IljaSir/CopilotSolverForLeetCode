class Solution {
    public String greatestLetter(String s) {
        
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String res = "";
        for (int i = 0; i < s.length() - 1; i++) {
            if (arr[i] == arr[i + 1]) continue;
            if (arr[i] + 32 == arr[i + 1]) {
                res = Character.toString(arr[i + 1]).toUpperCase();
            }
        }
        return res;
    }
}