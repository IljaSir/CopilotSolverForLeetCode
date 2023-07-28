impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut count = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() && nums[i] == nums[j] {
                j += 1;
            }
            if j < nums.len() {
                count += j - i;
            }
            i = j;
        }
        count
    }
}