impl Solution {
    pub fn halve_array(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
        }
        nums.sort_unstable();
        let mut res = 0;
        let mut i = nums.len() - 1;
        while sum > sum / 2 {
            sum -= nums[i];
            i -= 1;
            res += 1;
        }
        res
    }
}