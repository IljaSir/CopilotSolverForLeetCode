impl Solution {
    pub fn max_score_sightseeing_pair(values: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut mx = values[0];
        for i in 1..values.len() {
            ans = ans.max(mx + values[i] - i as i32);
            mx = mx.max(values[i] + i as i32);
        }
        ans
    }
}