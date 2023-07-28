impl Solution {
    pub fn smallest_number(pattern: String) -> String {
        
        let mut ans = String::new();
        let mut i = 1;
        let mut j = pattern.len() as i32 + 1;
        for c in pattern.chars() {
            match c {
                'I' => {
                    ans.push_str(&i.to_string());
                    i += 1;
                },
                'D' => {
                    ans.push_str(&j.to_string());
                    j -= 1;
                },
                _ => unreachable!(),
            }
        }
        ans.push_str(&j.to_string());
        ans
    }
}