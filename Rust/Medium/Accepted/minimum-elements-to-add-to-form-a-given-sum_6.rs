impl Solution {
    pub fn min_elements(nums: Vec<i32>, limit: i32, goal: i32) -> i32 {
        
        let sum: i64 = nums.iter().map(|x| *x as i64).sum();
        let goal: i64 = goal as i64;
        let limit: i64 = limit as i64;
        let diff = (goal - sum).abs();
        let mut res = diff / limit;
        if diff % limit != 0 {
            res += 1;
        }
        res as i32
    }
}