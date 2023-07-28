impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<i32>) -> String {
        
        let mut s = s.into_bytes();
        let mut sum = shifts.iter().sum::<i32>();
        for i in 0..s.len() {
            sum -= shifts[i];
            s[i] = (s[i] as i32 + sum % 26) as u8;
            if s[i] > 122 {
                s[i] -= 26;
            }
        }
        String::from_utf8(s).unwrap()
    }
}