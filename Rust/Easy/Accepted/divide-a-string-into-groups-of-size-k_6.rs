impl Solution {
    pub fn divide_string(s: String, k: i32, fill: char) -> Vec<String> {
        
        let mut result = vec![];
        let mut s = s.chars().collect::<Vec<char>>();
        let mut i = 0;
        let mut j = 0;
        while i < s.len() {
            j = i + k as usize;
            if j > s.len() {
                let mut tmp = vec![];
                while i < s.len() {
                    tmp.push(s[i]);
                    i += 1;
                }
                while tmp.len() < k as usize {
                    tmp.push(fill);
                }
                result.push(tmp.iter().collect());
            } else {
                result.push(s[i..j].iter().collect());
                i = j;
            }
        }
        result
    }
}