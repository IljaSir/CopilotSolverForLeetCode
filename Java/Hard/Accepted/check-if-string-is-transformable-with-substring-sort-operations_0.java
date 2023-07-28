class Solution {
    public boolean isTransformable(String s, String t) {
        
        int n = s.length();
        List<Integer>[] pos = new List[10];
        for (int i = 0; i < 10; i++) {
            pos[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            pos[s.charAt(i) - '0'].add(i);
        }
        for (int i = 0; i < n; i++) {
            int d = t.charAt(i) - '0';
            if (pos[d].isEmpty()) {
                return false;
            }
            for (int j = 0; j < d; j++) {
                if (!pos[j].isEmpty() && pos[j].get(0) < pos[d].get(0)) {
                    return false;
                }
            }
            pos[d].remove(0);
        }
        return true;
    }
}