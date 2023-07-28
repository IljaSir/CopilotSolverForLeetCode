impl Solution {
    pub fn max_score_sightseeing_pair(values: Vec<i32>) -> i32 {
        
        let (mut max, mut res) = (values[0] + 0, 0);
        for j in 1..values.len() {
            res = res.max(max + values[j] - j as i32);
            max = max.max(values[j] + j as i32);
        }
        res
    }
}