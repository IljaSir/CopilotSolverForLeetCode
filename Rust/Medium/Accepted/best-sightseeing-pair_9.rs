impl Solution {
    pub fn max_score_sightseeing_pair(values: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut cur = 0;
        for i in 0..values.len() {
            let v = values[i];
            max = max.max(cur + v);
            cur = cur.max(v) - 1;
        }
        max
    }
}