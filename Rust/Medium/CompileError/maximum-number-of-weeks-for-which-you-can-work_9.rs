impl Solution {
    pub fn number_of_weeks(milestones: Vec<i32>) -> i64 {
        
        let mut sum = 0;
        let mut max = 0;
        for item in milestones {
            sum += item;
            max = max.max(item);
        }
        let res = sum - max;
        if res >= max {
            sum as i64
        } else {
            res * 2 + 1
        }
    }
}