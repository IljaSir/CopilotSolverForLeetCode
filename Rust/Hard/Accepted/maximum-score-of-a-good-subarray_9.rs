impl Solution {
    pub fn maximum_score(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut k = k as usize;
        let mut left = k;
        let mut right = k;
        let mut max = nums[k];
        let mut ans = max;
        while left > 0 || right < nums.len() - 1 {
            let l = if left == 0 { i32::MIN } else { nums[left - 1] };
            let r = if right == nums.len() - 1 { i32::MIN } else { nums[right + 1] };
            if l < r {
                right += 1;
                max = max.min(nums[right]);
            } else {
                left -= 1;
                max = max.min(nums[left]);
            }
            ans = ans.max(max * (right - left + 1) as i32);
        }
        ans
    }
}