impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<Vec<i32>>) -> String {
        
        let mut shifts = shifts;
        let mut s = s.into_bytes();
        let mut sum = 0;
        for i in (0..shifts.len()).rev() {
            sum += shifts[i][2];
            sum %= 26;
            s[shifts[i][0] as usize] = ((s[shifts[i][0] as usize] as i32 - 'a' as i32 + sum) % 26 + 'a' as i32) as u8;
        }
        String::from_utf8(s).unwrap()
    }
}