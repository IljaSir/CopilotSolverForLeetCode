impl Solution {
    pub fn maximum_top(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        let mut j = nums.len() - 1;
        let mut k = k as usize;
        while i < j {
            let d = (j - i) * (nums[j] - nums[i]);
            if k < d {
                return nums[i] + k as i32 / (j - i) as i32;
            } else {
                k -= d;
                i += 1;
            }
        }
        nums[i]
    }
}