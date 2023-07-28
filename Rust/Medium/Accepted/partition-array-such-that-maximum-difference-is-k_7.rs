impl Solution {
    pub fn partition_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let mut nums = nums;
        nums.sort();
        let mut r = 0;
        let mut i = 0;
        while i < n {
            let mut j = i + 1;
            while j < n && nums[j] - nums[i] <= k {
                j += 1;
            }
            r += 1;
            i = j;
        }
        r
    }
}