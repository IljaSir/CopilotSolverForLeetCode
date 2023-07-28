impl Solution {
    pub fn letter_case_permutation(s: String) -> Vec<String> {
        
        let mut result = Vec::new();
        result.push("".to_string());
        for c in s.chars() {
            let mut new_result = Vec::new();
            if c.is_ascii_digit() {
                for prev in result.iter() {
                    let mut new_string = prev.clone();
                    new_string.push(c);
                    new_result.push(new_string);
                }
            } else {
                for prev in result.iter() {
                    let mut new_string = prev.clone();
                    new_string.push(c.to_ascii_lowercase());
                    new_result.push(new_string);
                }
                for prev in result.iter() {
                    let mut new_string = prev.clone();
                    new_string.push(c.to_ascii_uppercase());
                    new_result.push(new_string);
                }
            }
            result = new_result;
        }
        result
    }
}