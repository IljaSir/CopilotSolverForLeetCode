class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        int n = people.length;
        int left = 0, right = n - 1, ans = 0;
        while (left <= right) {
            if (left == right) {
                ans++;
                break;
            }
            if (people[left] + people[right] <= limit) {
                ans++;
                left++;
                right--;
            } else {
                ans++;
                right--;
            }
        }
        return ans;
    }
}