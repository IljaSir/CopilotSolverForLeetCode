impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<i32>) -> String {
        
        let mut shifts = shifts;
        let mut sum = shifts.iter().sum::<i32>();
        let mut res = String::new();
        for i in 0..s.len() {
            let c = s.as_bytes()[i];
            let c = (c - b'a' + (sum % 26) as u8) % 26;
            res.push((c + b'a') as char);
            sum -= shifts[i];
        }
        res
    }
}