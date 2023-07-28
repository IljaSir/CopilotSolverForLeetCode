class Solution {
    public boolean canChange(String start, String target) {
        
        int n = start.length();
        boolean[] visited = new boolean[n];
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (start.charAt(i) != '_') {
                if (start.charAt(i) != target.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            } else {
                if (start.charAt(i) == target.charAt(j)) {
                    i++;
                    j++;
                } else {
                    if (visited[i]) {
                        return false;
                    } else {
                        visited[i] = true;
                        i++;
                    }
                }
            }
        }
        return true;
    }
    public boolean canTransform(String start, String target) {
        if (start.length() != target.length()) {
            return false;
        }
        return canChange(start, target) && canChange(new StringBuilder(start).reverse().toString(), new StringBuilder(target).reverse().toString());
    }
}