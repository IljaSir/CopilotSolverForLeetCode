class Solution {
    public List<String> buildArray(int[] target, int n) {
        
        List<String> result = new ArrayList<>();
        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (j < target.length && target[j] == i) {
                result.add("Push");
                j++;
            } else if (j < target.length && target[j] < i) {
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }
}