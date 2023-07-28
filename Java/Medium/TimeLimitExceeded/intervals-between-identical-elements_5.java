class Solution {
    public long[] getDistances(int[] arr) {
        
        long[] ans = new long[arr.length];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.get(arr[i]).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(arr[i], list);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = map.get(arr[i]);
            long sum = 0;
            for (int j = 0; j < list.size(); j++) {
                sum += Math.abs(i - list.get(j));
            }
            ans[i] = sum;
        }
        return ans;
    }
}