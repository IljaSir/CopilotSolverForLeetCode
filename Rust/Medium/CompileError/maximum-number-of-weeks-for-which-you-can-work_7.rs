impl Solution {
    pub fn number_of_weeks(milestones: Vec<i32>) -> i64 {
        
        let mut max = 0;
        let mut sum = 0;
        for &m in milestones.iter() {
            sum += m;
            max = max.max(m);
        }
        sum - max + 1
    }
}