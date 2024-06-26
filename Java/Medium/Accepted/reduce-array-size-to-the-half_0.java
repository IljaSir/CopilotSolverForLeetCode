class Solution {
    public int minSetSize(int[] arr) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        int sum = 0, count = 0;
        for (int i : list) {
            sum += i;
            count++;
            if (sum >= arr.length / 2) {
                break;
            }
        }
        return count;
    }
}