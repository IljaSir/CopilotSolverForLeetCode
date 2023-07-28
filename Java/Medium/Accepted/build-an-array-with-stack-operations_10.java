class Solution {
    public List<String> buildArray(int[] target, int n) {
        
        List<String> result = new ArrayList<>();
        int i = 0;
        for (int j = 1; j <= n; j++) {
            if (i == target.length) {
                break;
            }
            if (target[i] == j) {
                result.add("Push");
                i++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }
}