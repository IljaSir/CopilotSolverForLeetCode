class Solution {
    public String simplifyPath(String path) {
        
        String[] parts = path.split("/");
        int n = parts.length;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (parts[j].equals("..")) {
                i = Math.max(i - 1, 0);
            } else if (!parts[j].equals(".") && !parts[j].equals("")) {
                parts[i++] = parts[j];
            }
        }
        if (i == 0) return "/";
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append("/");
            sb.append(parts[j]);
        }
        return sb.toString();
    }
}