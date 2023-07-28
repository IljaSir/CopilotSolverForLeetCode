impl Solution {
    pub fn divide_string(s: String, k: i32, fill: char) -> Vec<String> {
        
        let mut result = vec![];
        let mut s = s.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i < s.len() {
            let mut group = vec![];
            for _ in 0..k {
                if i < s.len() {
                    group.push(s[i]);
                } else {
                    group.push(fill);
                }
                i += 1;
            }
            result.push(group.iter().collect::<String>());
        }
        result
    }
}