impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<i32>) -> String {
        
        let mut s = s.into_bytes();
        let mut sum = shifts.iter().sum::<i32>();
        for i in 0..s.len() {
            s[i] = (b'a' + ((s[i] - b'a' + sum as u8) % 26)) as u8;
            sum -= shifts[i];
        }
        unsafe { String::from_utf8_unchecked(s) }
    }
}