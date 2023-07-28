class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if(diff < minDiff) {
                minDiff = diff;
                result.clear();
            }
            if(diff == minDiff) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                result.add(pair);
            }
        }
        return result;
    }
}