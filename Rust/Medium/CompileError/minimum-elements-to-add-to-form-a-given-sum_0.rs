impl Solution {
    pub fn min_elements(nums: Vec<i32>, limit: i32, goal: i32) -> i32 {
        
        let sum: i64 = nums.iter().map(|x| i64::from(*x)).sum();
        let goal: i64 = i64::from(goal);
        let limit: i64 = i64::from(limit);
        let diff = (goal - sum).abs();
        let (q, r) = (diff / limit, diff % limit);
        if r > 0 {
            q + 1
        } else {
            q
        }
    }
}