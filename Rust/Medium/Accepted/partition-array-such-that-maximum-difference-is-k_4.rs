impl Solution {
    pub fn partition_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 1;
        let mut min = nums[0];
        for i in 1..nums.len() {
            if nums[i] - min > k {
                ans += 1;
                min = nums[i];
            }
        }
        ans
    }
}