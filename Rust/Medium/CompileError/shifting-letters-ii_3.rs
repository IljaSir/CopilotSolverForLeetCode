impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<Vec<i32>>) -> String {
        
        let mut shifts = shifts;
        let mut s = s;
        let mut sum = 0;
        for i in (0..shifts.len()).rev() {
            sum = (sum + shifts[i][2]) % 26;
            shifts[i][2] = sum;
        }
        for i in 0..shifts.len() {
            let idx = shifts[i][0] as usize;
            let shift = shifts[i][2] as u8;
            let ch = s.as_bytes()[idx];
            if ch + shift > b'z' {
                s.as_bytes_mut()[idx] = b'a' + (ch + shift - b'z' - 1);
            } else {
                s.as_bytes_mut()[idx] = ch + shift;
            }
        }
        s
    }
}