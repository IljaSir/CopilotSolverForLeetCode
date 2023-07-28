class Solution {
    public int[] frequencySort(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[nums.length];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            for(int i = 0; i < freq; i++){
                res[index++] = entry.getKey();
            }
        }
        Arrays.sort(res);
        return res;
    }
}