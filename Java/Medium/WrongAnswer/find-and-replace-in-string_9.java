class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int l = s.length();
        int k = indices.length;
        int[] mask = new int[l];
        for (int i = 0; i < k; i++) {
            int index = indices[i];
            String source = sources[i];
            String target = targets[i];
            if (index + source.length() <= l && s.substring(index, index + source.length()).equals(source)) {
                for (int j = index; j < index + source.length(); j++) {
                    mask[j] = 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l; i++) {
            if (mask[i] == 1) {
                sb.append(targets[getIndex(indices, i)]);
                while (i < l - 1 && mask[i + 1] == 1) {
                    i++;
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    
    public int getIndex(int[] indices, int index) {
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] == index) {
                return i;
            }
        }
        return -1;
    }
}