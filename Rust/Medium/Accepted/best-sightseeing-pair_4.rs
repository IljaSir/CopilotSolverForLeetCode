impl Solution {
    pub fn max_score_sightseeing_pair(values: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut cur = values[0];
        for i in 1..values.len() {
            max = max.max(cur + values[i] - i as i32);
            cur = cur.max(values[i] + i as i32);
        }
        max
    }
}