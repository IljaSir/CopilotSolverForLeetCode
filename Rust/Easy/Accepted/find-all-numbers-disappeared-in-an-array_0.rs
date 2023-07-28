impl Solution {
    pub fn find_disappeared_numbers(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        for i in 0..nums.len() {
            let idx = (nums[i].abs() - 1) as usize;
            nums[idx] = -nums[idx].abs();
        }
        let mut ans = Vec::new();
        for i in 0..nums.len() {
            if nums[i] > 0 {
                ans.push((i + 1) as i32);
            }
        }
        ans
    }
}