class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int c = Integer.bitCount(o1) - Integer.bitCount(o2);
                if (c != 0) {
                    return c;
                }
                return o1 - o2;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i];
        }
        return arr;
    }
}