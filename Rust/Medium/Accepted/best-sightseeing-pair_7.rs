impl Solution {
    pub fn max_score_sightseeing_pair(values: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut max_value = values[0];
        for i in 1..values.len() {
            max = std::cmp::max(max, max_value + values[i] - i as i32);
            max_value = std::cmp::max(max_value, values[i] + i as i32);
        }
        max
    }
}