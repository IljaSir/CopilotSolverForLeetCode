class Solution {
    public String reverseVowels(String s) {
        
        int i = 0, j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (!isVowel(arr[i])) {
                i++;
            } else if (!isVowel(arr[j])) {
                j--;
            } else {
                char tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}