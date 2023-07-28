impl Solution {
    pub fn max_count(banned: Vec<i32>, n: i32, max_sum: i32) -> i32 {
        
        let mut max = max_sum;
        for i in 0..banned.len() {
            max -= banned[i];
        }
        let mut count = 0;
        for i in 1..=n {
            if max - i >= 0 {
                count += 1;
                max -= i;
            } else {
                break;
            }
        }
        count
    }
}