impl Solution {
    pub fn number_of_weeks(milestones: Vec<i32>) -> i64 {
        
        let mut sum = 0;
        let mut max = 0;
        for m in milestones {
            sum += m;
            if m > max {
                max = m;
            }
        }
        if max > sum - max {
            (sum - max) * 2 + 1
        } else {
            sum
        }
    }
}