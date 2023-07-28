impl Solution {
    pub fn num_pairs_divisible_by60(time: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut remainders = vec![0; 60];
        for t in time {
            let rem = t % 60;
            count += remainders[(60 - rem) % 60];
            remainders[rem as usize] += 1;
        }
        count
    }
}