impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<i32>) -> String {
        
        let mut shifts = shifts;
        let mut sum = 0;
        for i in (0..shifts.len()).rev() {
            sum = (sum + shifts[i]) % 26;
            shifts[i] = sum;
        }
        s.chars()
            .zip(shifts.into_iter())
            .map(|(c, s)| (((c as i32 - 97 + s) % 26) + 97) as u8 as char)
            .collect()
    }
}