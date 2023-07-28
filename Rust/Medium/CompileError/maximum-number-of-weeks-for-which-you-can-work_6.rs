impl Solution {
    pub fn number_of_weeks(milestones: Vec<i32>) -> i64 {
        
        let mut max = 0;
        let mut sum = 0;
        for m in milestones {
            sum += m;
            max = max.max(m);
        }
        let remain = sum - max;
        if remain >= max {
            return sum as i64;
        }
        remain * 2 + 1
    }
}