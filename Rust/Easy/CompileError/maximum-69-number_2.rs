impl Solution {
    pub fn maximum69_number (num: i32) -> i32 {
        
        let mut s = num.to_string();
        let mut max = num;
        for i in 0..s.len() {
            if s.as_bytes()[i] == b'6' {
                s.as_bytes_mut()[i] = b'9';
                max = max.max(s.parse::<i32>().unwrap());
                s.as_bytes_mut()[i] = b'6';
            }
        }
        max
    }
}