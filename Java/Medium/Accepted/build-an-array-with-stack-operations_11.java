class Solution {
    public List<String> buildArray(int[] target, int n) {
        
        List<String> result = new ArrayList<String>();
        int i = 1;
        for (int val : target) {
            while (i < val) {
                result.add("Push");
                result.add("Pop");
                i++;
            }
            result.add("Push");
            i++;
        }
        return result;
    }
}