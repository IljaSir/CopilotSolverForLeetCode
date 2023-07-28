class Solution {
    public String modifyString(String s) {
        
        char[] arr = s.toCharArray();
        char[] result = new char[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '?') {
                char c = 'a';
                while (c == result[i - 1] || c == arr[i + 1]) {
                    c++;
                }
                result[i] = c;
            } else {
                result[i] = arr[i];
            }
        }
        return new String(result);
    }
}