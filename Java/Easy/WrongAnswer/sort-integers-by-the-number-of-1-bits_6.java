class Solution {
    public int[] sortByBits(int[] arr) {
        
        int[] result = new int[arr.length];
        int[] bits = new int[10001];
        for (int i = 0; i < arr.length; i++) {
            bits[arr[i]] = getBits(arr[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] != 0) {
                list.add(i);
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (bits[o1] != bits[o2]) {
                    return bits[o1] - bits[o2];
                } else {
                    return o1 - o2;
                }
            }
        });
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private int getBits(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}