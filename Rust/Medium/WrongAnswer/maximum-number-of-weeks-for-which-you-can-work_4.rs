impl Solution {
    pub fn number_of_weeks(milestones: Vec<i32>) -> i64 {
        
        let mut sum: i64 = 0;
        let mut max: i32 = 0;
        for m in milestones {
            sum += m as i64;
            max = max.max(m);
        }
        sum - max.max(1) as i64 + 1
    }
}