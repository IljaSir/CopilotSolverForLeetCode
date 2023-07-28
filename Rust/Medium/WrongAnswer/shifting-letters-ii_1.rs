impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<Vec<i32>>) -> String {
        
        let mut s = s.into_bytes();
        let mut sum = 0;
        for shift in shifts.into_iter().rev() {
            let (start, end, direction) = (shift[0], shift[1], shift[2]);
            sum += (end - start + 1) * direction;
            for i in start..=end {
                s[i as usize] = ((s[i as usize] as i32 - 'a' as i32 + sum) % 26 + 'a' as i32) as u8;
            }
        }
        String::from_utf8(s).unwrap()
    }
}