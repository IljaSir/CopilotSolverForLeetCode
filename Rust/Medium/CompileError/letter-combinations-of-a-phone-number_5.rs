impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        

        let mut result = Vec::new();
        let mut tmp = Vec::new();
        for c in digits.chars() {
            let v = match c {
                '2' => vec!['a', 'b', 'c'],
                '3' => vec!['d', 'e', 'f'],
                '4' => vec!['g', 'h', 'i'],
                '5' => vec!['j', 'k', 'l'],
                '6' => vec!['m', 'n', 'o'],
                '7' => vec!['p', 'q', 'r', 's'],
                '8' => vec!['t', 'u', 'v'],
                '9' => vec!['w', 'x', 'y', 'z'],
                _ => Vec::new(),
            };
            if v.is_empty() {
                continue;
            }
            if tmp.is_empty() {
                tmp = v;
            } else {
                let mut new_tmp = Vec::new();
                for c1 in tmp {
                    for c2 in &v {
                        new_tmp.push(format!("{}{}", c1, c2));
                    }
                }
                tmp = new_tmp;
            }
        }
        if !tmp.is_empty() {
            result = tmp;
        }
        result
    }
}