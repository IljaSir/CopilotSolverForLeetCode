impl Solution {
    pub fn largest_odd_number(num: String) -> String {
        
        let mut i = num.len() - 1;
        while i > 0 {
            if num.as_bytes()[i] % 2 == 1 {
                return num[0..=i].to_string();
            }
            i -= 1;
        }
        String::from("")
    }
}