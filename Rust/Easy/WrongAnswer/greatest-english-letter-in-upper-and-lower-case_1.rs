impl Solution {
    pub fn greatest_letter(s: String) -> String {
        
        let mut a = 0;
        for c in s.chars() {
            if c.is_lowercase() {
                a |= 1 << (c as u8 - b'a');
            } else {
                a |= 1 << (c as u8 - b'A');
            }
        }
        let mut c = b'A';
        for i in (0..26).rev() {
            if a & (1 << i) > 0 {
                c += i as u8;
                break;
            }
        }
        if c > b'Z' {
            String::from("")
        } else {
            String::from_utf8(vec![c]).unwrap()
        }
    }
}