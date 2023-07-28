impl Solution {
    pub fn number_of_weeks(milestones: Vec<i32>) -> i64 {
        
        let mut sum = 0;
        let mut max = 0;
        for i in 0..milestones.len() {
            sum += milestones[i];
            if milestones[i] > max {
                max = milestones[i];
            }
        }
        let rest = sum - max;
        if max <= rest + 1 {
            return sum as i64;
        }
        return 2 * rest + 1;
    }
}