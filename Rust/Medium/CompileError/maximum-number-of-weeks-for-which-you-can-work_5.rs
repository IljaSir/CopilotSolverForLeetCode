impl Solution {
    pub fn number_of_weeks(milestones: Vec<i32>) -> i64 {
        
        let mut max = 0;
        let mut sum = 0;
        for i in milestones {
            if i > max {
                max = i;
            }
            sum += i;
        }
        if max > sum - max {
            return (sum - max) * 2 + 1;
        }
        return sum as i64;
    }
}