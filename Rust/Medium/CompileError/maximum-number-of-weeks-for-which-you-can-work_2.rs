impl Solution {
    pub fn number_of_weeks(milestones: Vec<i32>) -> i64 {
        
        let mut max = 0;
        let mut sum = 0;
        for i in 0..milestones.len() {
            max = max.max(milestones[i]);
            sum += milestones[i];
        }
        (sum - max).min(max - 1) * 2 + 1
    }
}