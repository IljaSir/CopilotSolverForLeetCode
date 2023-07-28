impl Solution {
    pub fn number_of_weeks(milestones: Vec<i32>) -> i64 {
        
        let mut max = 0;
        let mut sum = 0;
        for i in 0..milestones.len() {
            sum += milestones[i];
            if milestones[i] > max {
                max = milestones[i];
            }
        }
        if max > sum - max + 1 {
            (sum - max) * 2 + 1
        } else {
            sum
        }
    }
}