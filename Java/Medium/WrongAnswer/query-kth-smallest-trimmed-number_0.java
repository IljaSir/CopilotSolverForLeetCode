class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++) {
                String str = nums[j].substring(0, trim);
                list.add(Integer.valueOf(str));
            }
            Collections.sort(list);
            answer[i] = list.get(k - 1);
        }
        return answer;
    }
}