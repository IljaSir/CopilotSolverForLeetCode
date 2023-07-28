impl Solution {
    pub fn reduction_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = 1;
        let mut count = 0;
        let mut ans = 0;
        while j < nums.len() {
            if nums[i] == nums[j] {
                count += 1;
            } else {
                ans += count;
                count += 1;
                i = j;
            }
            j += 1;
        }
        ans
    }
}