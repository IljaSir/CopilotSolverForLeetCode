impl Solution {
    pub fn freq_alphabets(s: String) -> String {
        
        let mut result = String::new();
        let mut i = 0;
        while i < s.len() {
            if i + 2 < s.len() && s.chars().nth(i + 2).unwrap() == '#' {
                let num = s[i..i+2].parse::<u8>().unwrap();
                result.push((num + 96) as char);
                i += 3;
            } else {
                let num = s[i..i+1].parse::<u8>().unwrap();
                result.push((num + 96) as char);
                i += 1;
            }
        }
        result
    }
}