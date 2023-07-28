impl Solution {
    pub fn license_key_formatting(s: String, k: i32) -> String {
        
        let mut s = s.chars().rev().filter(|c| *c != '-').collect::<String>();
        let mut i = 0;
        while i + k < s.len() as i32 {
            s.insert((i + k) as usize, '-');
            i += k + 1;
        }
        s.chars().rev().collect::<String>().to_uppercase()
    }
}