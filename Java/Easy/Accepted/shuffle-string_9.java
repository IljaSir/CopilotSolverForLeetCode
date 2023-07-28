class Solution {
    public String restoreString(String s, int[] indices) {
        
        char[] sArray = s.toCharArray();
        char[] result = new char[sArray.length];
        for (int i = 0; i < sArray.length; i++) {
            result[indices[i]] = sArray[i];
        }
        return new String(result);
    }
}