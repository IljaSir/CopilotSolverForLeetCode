impl Solution {
    pub fn num_pairs_divisible_by60(time: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut time = time;
        for i in 0..time.len() {
            for j in i+1..time.len() {
                if (time[i] + time[j]) % 60 == 0 {
                    count += 1;
                }
            }
        }
        count
    }
}