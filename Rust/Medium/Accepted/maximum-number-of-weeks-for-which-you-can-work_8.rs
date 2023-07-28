impl Solution {
    pub fn number_of_weeks(milestones: Vec<i32>) -> i64 {
        
        let mut sorted = milestones;
        sorted.sort();
        let mut sum = 0;
        for i in 0..sorted.len()-1 {
            sum += sorted[i] as i64;
        }
        let max = sorted[sorted.len()-1] as i64;
        if sum < max {
            return sum*2+1;
        }
        return sum+max;
    }
}