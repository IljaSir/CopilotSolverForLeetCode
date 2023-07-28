class Solution {
    public List<String> buildArray(int[] target, int n) {
        
        List<String> result = new ArrayList<String>();
        int j = 0;
        for (int i = 1; i <= n && j < target.length; i++) {
            result.add("Push");
            if (i != target[j]) {
                result.add("Po) {
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