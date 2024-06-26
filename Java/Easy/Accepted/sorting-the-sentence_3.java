class Solution {
    public String sortSentence(String s) {
        
        String[] arr = s.split(" ");
        String[] res = new String[arr.length];
        for (String str : arr) {
            res[str.charAt(str.length() - 1) - '1'] = str.substring(0, str.length() - 1);
        }
        return String.join(" ", res);
    }
}