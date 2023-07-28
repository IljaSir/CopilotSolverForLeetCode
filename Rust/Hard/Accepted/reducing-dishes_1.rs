impl Solution {
    pub fn max_satisfaction(satisfaction: Vec<i32>) -> i32 {
        
        let mut satisfaction = satisfaction;
        satisfaction.sort();
        let mut sum = 0;
        let mut res = 0;
        for &s in satisfaction.iter().rev() {
            sum += s;
            if sum < 0 {
                break;
            }
            res += sum;
        }
        res
    }
}