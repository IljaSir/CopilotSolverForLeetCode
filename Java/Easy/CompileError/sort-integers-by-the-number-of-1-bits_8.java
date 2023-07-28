class Solution {
    public int[] sortByBits(int[] arr) {
        
        int n = arr.length;
        int[] res = new int[n];
        int[] count = new int[10001];
        for(int i = 0; i < n; i++) {
            count[arr[i]] = countOne(arr[i]);
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++) {
            res[i] = arr[i];
        }
        Arrays.sort(res, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return count[a] - count[b];
            }
        });
        return res;
    }
    private int countOne(int n) {
        int count = 0;
        while(n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }
}