class Solution {
    public int[] arrayRankTransform(int[] arr) {
        
        int[] result = new int[arr.length];
        if (arr.length == 0) return result;
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        int count = 1;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(arrCopy[0], count);
        for (int i = 1; i < arrCopy.length; i++) {
            if (arrCopy[i] != arrCopy[i - 1]) {
                count++;
                map.put(arrCopy[i], count);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }
}