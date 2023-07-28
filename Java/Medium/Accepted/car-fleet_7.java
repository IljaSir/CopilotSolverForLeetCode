class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        if (position.length == 0) return 0;
        int res = 0;
        double time = 0;
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < position.length; i++) {
            map.put(position[i], (double) (target - position[i]) / speed[i]);
        }
        Arrays.sort(position);
        for (int i = position.length - 1; i >= 0; i--) {
            if (map.get(position[i]) > time) {
                res++;
                time = map.get(position[i]);
            }
        }
        return res;
    }
}