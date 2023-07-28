class Solution {
    public String restoreString(String s, int[] indices) {
        
        char[] str = s.toCharArray();
        char[] result = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            result[indices[i]] = str[i];
        }
        return new String(result);
    }
}