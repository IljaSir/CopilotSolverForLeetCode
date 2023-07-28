impl Solution {
    pub fn minimum_partition(s: String, k: i32) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        let mut result = 0;
        for c in s.chars() {
            let val = c.to_digit(10).unwrap();
            max = max.max(val);
            count += 1;
            if max * count as u32 > k as u32 {
                result += 1;
                max = 0;
                count = 0;
            }
        }
        if count > 0 {
            result += 1;
        }
        result
    }
}