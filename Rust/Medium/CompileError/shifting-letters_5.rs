impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<i32>) -> String {
        
        let mut shifts = shifts;
        let mut sum = 0;
        for i in shifts.iter_mut().rev() {
            *i = (*i + sum) % 26;
            sum += *i;
        }
        s.chars()
            .zip(shifts)
            .map(|(c, shift)| (((c as u8 - b'a') as i32 + shift) % 26 + b'a') as char)
            .collect()
    }
}