impl Solution {
    pub fn get_lucky(s: String, k: i32) -> i32 {
        
        let mut t = String::new();
        for c in s.chars() {
            t.push_str(&(c as u8 - b'a' + 1).to_string());
        }
        let mut x = t.parse::<i32>().unwrap();
        for _ in 0..k {
            let mut y = 0;
            while x > 0 {
                y += x % 10;
                x /= 10;
            }
            x = y;
        }
        x
    }
}