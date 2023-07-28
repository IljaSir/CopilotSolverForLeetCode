impl Solution {
    pub fn max_frequency(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = 1;
        let mut i = 0;
        let mut sum = 0;
        for j in 1..nums.len() {
            sum += (nums[j] - nums[j - 1]) * (j - i) as i32;
            while sum > k {
                sum -= nums[j] - nums[i];
                i += 1;
            }
            ans = ans.max(j - i + 1);
        }
        ans as i32
    }
}