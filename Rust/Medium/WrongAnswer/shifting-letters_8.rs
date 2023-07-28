impl Solution {
    pub fn shifting_letters(s: String, shifts: Vec<i32>) -> String {
        
        let mut result = Vec::new();
        let mut sum = 0;
        for (i, c) in s.chars().rev().enumerate() {
            sum += shifts[shifts.len() - i - 1];
            result.push(((c as u8) + (sum % 26) as u8 - 97) % 26 + 97);
        }
        result.into_iter().rev().map(|c| c as char).collect()
    }
}