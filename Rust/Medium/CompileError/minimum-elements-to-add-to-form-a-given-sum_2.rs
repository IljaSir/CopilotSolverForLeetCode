impl Solution {
    pub fn min_elements(nums: Vec<i32>, limit: i32, goal: i32) -> i32 {
        
        let mut sum: i64 = 0;
        for i in 0..nums.len() {
            sum += nums[i] as i64;
        }
        let diff: i64 = (goal - sum).abs();
        let mut res: i32 = (diff / limit as i64) as i32;
        if diff % limit as i64 > 0 {
            res += 1;
        }
        return res;
    }
}