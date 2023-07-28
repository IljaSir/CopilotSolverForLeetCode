impl Solution {
    pub fn max_score_sightseeing_pair(values: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut cur = 0;
        for &v in values.iter() {
            res = res.max(cur + v);
            cur = cur.max(v) - 1;
        }
        res
    }
}