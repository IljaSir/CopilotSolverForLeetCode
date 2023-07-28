impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<i32>) -> String {
        
        let mut s = s.into_bytes();
        let mut shifts = shifts;
        let mut sum = 0;
        for i in (0..shifts.len()).rev() {
            sum = (sum + shifts[i]) % 26;
            s[i] = ((s[i] - b'a' + sum as u8) % 26 + b'a') as u8;
        }
        String::from_utf8(s).unwrap()
    }
}