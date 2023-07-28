impl Solution {
    pub fn max_score_sightseeing_pair(values: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut max_i = values[0];
        for i in 1..values.len() {
            max = max.max(max_i + values[i] - i as i32);
            max_i = max_i.max(values[i] + i as i32);
        }
        max
    }
}