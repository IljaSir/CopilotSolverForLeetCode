impl Solution {
    pub fn max_score_sightseeing_pair(values: Vec<i32>) -> i32 {
        
        let mut max = values[0];
        let mut ans = 0;
        for i in 1..values.len() {
            ans = ans.max(max + values[i] - i as i32);
            max = max.max(values[i] + i as i32);
        }
        ans
    }
}