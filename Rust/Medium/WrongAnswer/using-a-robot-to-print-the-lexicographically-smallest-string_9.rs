impl Solution {
    pub fn robot_with_string(s: String) -> String {
        
        let mut result = String::new();
        let mut chars = s.chars().collect::<Vec<char>>();
        while !chars.is_empty() {
            let mut left = true;
            for i in 0..chars.len() {
                if chars[i] < chars[chars.len() - 1 - i] {
                    left = true;
                    break;
                } else if chars[i] > chars[chars.len() - 1 - i] {
                    left = false;
                    break;
                }
            }
            if left {
                result.push(chars.remove(0));
            } else {
                result.push(chars.pop().unwrap());
            }
        }
        result
    }
}