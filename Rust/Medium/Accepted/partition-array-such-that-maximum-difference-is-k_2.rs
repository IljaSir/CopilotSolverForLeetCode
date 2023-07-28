impl Solution {
    pub fn partition_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 1;
        let mut max = nums[0];
        let mut min = nums[0];
        for i in 1..nums.len() {
            max = max.max(nums[i]);
            min = min.min(nums[i]);
            if max - min > k {
                ans += 1;
                max = nums[i];
                min = nums[i];
            }
        }
        ans
    }
}