class Solution {
    public String reverseWords(String s) {
        
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(new StringBuilder(str).reverse().toString()).append(" ");
        }
        return sb.toString().trim();
    }
}