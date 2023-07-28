class Solution {
    public int balancedString(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        map.put('Q', 0);
        map.put('W', 0);
        map.put('E', 0);
        map.put('R', 0);
        for (char c : s.toCharArray()) {
            map.put(c, map.get(c) + 1);
        }
        int n = s.length();
        int res = n;
        int i = 0;
        for (int j = 0; j < n; j++) {
            map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
            while (i < n && map.get('Q') <= n / 4 && map.get('W') <= n / 4 && map.get('E') <= n / 4 && map.get('R') <= n / 4) {
                res = Math.min(res, j - i + 1);
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                i++;
            }
        }
        return res;
    }
}