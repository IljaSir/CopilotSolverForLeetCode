class Solution {
    public String restoreString(String s, int[] indices) {
        
        char[] chars = s.toCharArray();
        char[] result = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            result[indices[i]] = chars[i];
        }
        return new String(result);
    }
}