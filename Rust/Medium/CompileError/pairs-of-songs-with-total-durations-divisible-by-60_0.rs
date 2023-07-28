impl Solution {
    pub fn num_pairs_divisible_by60(time: Vec<i32>) -> i32 {
        
        let mut res = 0;
        let mut cnt = vec![0; 60];
        for t in time {
            res += cnt[(60 - t % 60) % 60];
            cnt[t as usize % 60] += 1;
        }
        res
    }
}