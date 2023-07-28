impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<Vec<i32>>) -> String {
        
        let mut s: Vec<u8> = s.into_bytes();
        let mut shift = 0;
        for i in (0..shifts.len()).rev() {
            shift = (shift + shifts[i][2] * (shifts[i][1] - shifts[i][0] + 1)) % 26;
            s[shifts[i][0] as usize] = ((s[shifts[i][0] as usize] - b'a' + shift as u8) % 26 + b'a') as u8;
        }
        String::from_utf8(s).unwrap()
    }
}