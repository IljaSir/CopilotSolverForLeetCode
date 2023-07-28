impl Solution {
    pub fn partition_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 1;
        let mut cur_max = nums[0];
        let mut cur_min = nums[0];
        for i in 1..nums.len() {
            cur_max = cur_max.max(nums[i]);
            cur_min = cur_min.min(nums[i]);
            if cur_max - cur_min > k {
                ans += 1;
                cur_max = nums[i];
                cur_min = nums[i];
            }
        }
        ans
    }
}