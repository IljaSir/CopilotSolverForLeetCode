impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<i32>) -> String {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut sum = 0;
        for i in (0..shifts.len()).rev() {
            sum = (sum + shifts[i]) % 26;
            s[i] = ((s[i] as u8 - 97 + sum as u8) % 26 + 97) as char;
        }
        s.iter().collect()
    }
}