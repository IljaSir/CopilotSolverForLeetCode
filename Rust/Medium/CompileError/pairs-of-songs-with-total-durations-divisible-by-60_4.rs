impl Solution {
    pub fn num_pairs_divisible_by60(time: Vec<i32>) -> i32 {
        
        let mut counter = vec![0; 60];
        let mut ans = 0;
        for t in time {
            let t = t % 60;
            ans += counter[(60 - t) % 60];
            counter[t as usize] += 1;
        }
        ans
    }
}