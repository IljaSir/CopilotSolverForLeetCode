impl Solution {
    pub fn min_elements(nums: Vec<i32>, limit: i32, goal: i32) -> i32 {
        
        let sum: i64 = nums.iter().map(|x| *x as i64).sum();
        let diff = (goal as i64 - sum).abs();
        let mut res = diff / limit as i64;
        if diff % limit as i64 != 0 {
            res += 1;
        }
        res as i32
    }
}