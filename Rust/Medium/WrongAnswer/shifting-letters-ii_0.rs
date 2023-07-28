impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<Vec<i32>>) -> String {
        
        let mut v: Vec<char> = s.chars().collect();
        let mut sum = 0;
        for i in (0..shifts.len()).rev() {
            sum += shifts[i][2] * (shifts[i][1] - shifts[i][0] + 1);
            v[shifts[i][0] as usize] = ((v[shifts[i][0] as usize] as u8 - 'a' as u8 + sum as u8) % 26 + 'a' as u8) as char;
        }
        v.into_iter().collect()
    }
}