impl Solution {
    pub fn maximum69_number (num: i32) -> i32 {
        
        let mut s = num.to_string();
        let mut i = 0;
        while i < s.len() {
            if s.as_bytes()[i] == b'6' {
                s.replace_range(i..i+1, "9");
                break;
            }
            i += 1;
        }
        s.parse::<i32>().unwrap()
    }
}