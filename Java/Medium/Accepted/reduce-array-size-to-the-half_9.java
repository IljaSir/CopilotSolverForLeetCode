class Solution {
    public int minSetSize(int[] arr) {
        
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> freqs = new ArrayList<>(freq.values());
        Collections.sort(freqs, Collections.reverseOrder());
        int count = 0;
        int sum = 0;
        for (int i = 0; i < freqs.size(); i++) {
            sum += freqs.get(i);
            count++;
            if (sum >= n / 2) {
                break;
            }
        }
        return count;
    }
}