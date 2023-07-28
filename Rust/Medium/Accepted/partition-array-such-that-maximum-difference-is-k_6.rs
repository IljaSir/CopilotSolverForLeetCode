impl Solution {
    pub fn partition_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut count = 0;
        let mut i = 0;
        let mut j = 0;
        while i < nums.len() {
            j = i;
            while j < nums.len() && nums[j] - nums[i] <= k {
                j += 1;
            }
            count += 1;
            i = j;
        }
        count
    }
}