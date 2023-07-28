impl Solution {
    pub fn num_pairs_divisible_by60(time: Vec<i32>) -> i32 {
        
        let mut cnt = vec![0; 60];
        let mut ans = 0;
        for t in time {
            let t = t as usize;
            ans += cnt[(60 - t % 60) % 60];
            cnt[t % 60] += 1;
        }
        ans
    }
}