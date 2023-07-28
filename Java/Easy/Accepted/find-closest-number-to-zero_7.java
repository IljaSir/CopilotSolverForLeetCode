class Solution {
    public int findClosestNumber(int[] nums) {
        
        int closest = Integer.MAX_VALUE;
        int closestNumber = 0;
        for (int num : nums) {
            int distance = Math.abs(num);
            if (distance < closest || (distance == closest && num > closestNumber)) {
                closest = distance;
                closestNumber = num;
            }
        }
        return closestNumber;
    }
}