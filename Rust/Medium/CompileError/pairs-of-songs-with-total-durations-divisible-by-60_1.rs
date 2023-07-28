impl Solution {
    pub fn num_pairs_divisible_by60(time: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut m = vec![0; 60];
        for t in time {
            res += m[(60 - t % 60) % 60];
            m[t as usize % 60] += 1;
        }
        res
    }
}