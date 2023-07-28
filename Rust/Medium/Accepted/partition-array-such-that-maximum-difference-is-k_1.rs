impl Solution {
    pub fn partition_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut res = 1;
        let mut min = nums[0];
        let mut max = nums[0];
        for i in 1..nums.len() {
            if nums[i] - min > k {
                res += 1;
                min = nums[i];
                max = nums[i];
            } else {
                max = nums[i];
            }
        }
        res
    }
}