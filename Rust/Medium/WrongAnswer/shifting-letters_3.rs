impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<i32>) -> String {
        
        let mut s = s.into_bytes();
        let mut sum = 0;
        for i in (0..s.len()).rev() {
            sum += shifts[i];
            s[i] = ((s[i] as i32 - 97 + sum) % 26 + 97) as u8;
        }
        unsafe { String::from_utf8_unchecked(s) }
    }
}