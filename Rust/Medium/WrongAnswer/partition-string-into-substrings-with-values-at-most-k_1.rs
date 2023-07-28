impl Solution {
    pub fn minimum_partition(s: String, k: i32) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        for c in s.chars() {
            let n = c.to_digit(10).unwrap() as i32;
            max = max.max(n);
            if max > k {
                count += 1;
                max = n;
            }
        }
        count + 1
    }
}