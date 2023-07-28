class Solution {
    public String sortSentence(String s) {
        
        String[] arr = s.split(" ");
        String[] res = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i].charAt(arr[i].length() - 1) - '1';
            res[index] = arr[i].substring(0, arr[i].length() - 1);
        }
        return String.join(" ", res);
    }
}