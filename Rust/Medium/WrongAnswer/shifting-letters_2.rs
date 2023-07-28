impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<i32>) -> String {
        
        let mut s = s.into_bytes();
        let mut sum = 0;
        for i in (0..s.len()).rev() {
            sum += shifts[i];
            s[i] = ((s[i] - b'a' + (sum % 26) as u8) % 26 + b'a') as u8;
        }
        String::from_utf8(s).unwrap()
    }
}