class Solution {
    public int countTime(String time) {
        
        int count = 0;
        for (int h = 0; h < 24; h++) {
            for (int m = 0; m < 60; m++) {
                String t = String.format("%02d:%02d", h, m);
                if (isValid(time, t)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public boolean isValid(String time, String t) {
        for (int i = 0; i < time.length(); i++) {
            if (time.charAt(i) != '?' && time.charAt(i) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public int numDifferentIntegers(String word) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                int j = i;
                while (j < word.length() && Character.isDigit(word.charAt(j))) {
                    j++;
                }
                String num = word.substring(i, j);
                set.add(num);
                i = j;
            }
        }
        return set.size();
    }
    
    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int max = 0;
        for (int i = 0; i < light.length; i++) {
            max = Math.max(max, light[i]);
            if (max == i + 1) {
                ans++;
            }
        }
        return ans;
    }
    
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        int i = 0;
        int j = 1;
        for (int n : nums) {
            ans[i] = n;
            i += 2;
            if (i >= nums.length) {
                i = 1;
            }
        }
        return ans;
    }
    
    public int[] rearrangeBarcodes(int[] barcodes) {
        int[] ans = new int[barcodes.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : barcodes) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a
    }
}