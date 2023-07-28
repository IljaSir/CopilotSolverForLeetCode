class Solution {
    public List<String> buildArray(int[] target, int n) {
        
        List<String> result = new ArrayList<String>();
        int current = 0;
        for(int i=1; i<=n; i++) {
            if(current >= target.length) {
                break;
            }
            if(i == target[current]) {
                result.add("Push");
                current++;
            } else {
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }
}