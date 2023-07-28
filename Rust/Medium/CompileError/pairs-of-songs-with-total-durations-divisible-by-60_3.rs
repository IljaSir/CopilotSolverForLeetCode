impl Solution {
    pub fn num_pairs_divisible_by60(time: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut remainders = vec![0; 60];
        for t in time {
            let r = t % 60;
            if r == 0 {
                count += remainders[0];
            } else {
                count += remainders[60 - r];
            }
            remainders[r] += 1;
        }
        count
    }
}