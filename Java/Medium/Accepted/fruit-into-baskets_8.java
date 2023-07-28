class Solution {
    public int totalFruit(int[] fruits) {
        
        int ans = 0;
        int i = 0;
        int j = 0;
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            int cur = fruits[j];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            while (map.size() > 2) {
                int left = fruits[i];
                map.put(left, map.get(left) - 1);
                if (map.get(left) == 0) {
                    map.remove(left);
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
            j++;
        }
        return ans;
    }
}