impl Solution {
    pub fn num_pairs_divisible_by60(time: Vec<i32>) -> i32 {
        
        let mut cnt = vec![0; 60];
        let mut res = 0;
        for t in time {
            let t = t % 60;
            res += cnt[(60 - t) % 60];
            cnt[t as usize] += 1;
        }
        res
    }
}