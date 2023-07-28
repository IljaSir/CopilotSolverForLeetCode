class Solution {
    public int minOperations(int[] target, int[] arr) {
        
        int n = target.length;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            pos.put(target[i], i);
        }
        List<Integer> d = new ArrayList<>();
        for (int val: arr) {
            if (pos.containsKey(val)) {
                int idx = pos.get(val);
                int it = Collections.binarySearch(d, idx);
                if (it < 0) {
                    it = -it - 1;
                }
                if (it == d.size()) {
                    d.add(idx);
                } else {
                    d.set(it, idx);
                }
            }
        }
        return n - d.size();
    }
}