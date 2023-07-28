class Solution {
    public List<String> buildArray(int[] target, int n) {
        
        List<String> result = new ArrayList<>();
        int next = 1;
        for(int i = 0; i < target.length; i++) {
            while(target[i] != next) {
                result.add("Push");
                result.add("Pop");
                next++;
            }
            result.add("Push");
            next++;
        }
        return result;
    }
}