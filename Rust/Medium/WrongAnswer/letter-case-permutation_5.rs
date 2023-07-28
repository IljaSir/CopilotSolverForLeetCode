impl Solution {
    pub fn letter_case_permutation(s: String) -> Vec<String> {
        
        let mut res: Vec<String> = Vec::new();
        let mut chars: Vec<char> = s.chars().collect();
        let mut n = chars.len();
        let mut i = 0;
        while i < n {
            let c = chars[i];
            if c.is_alphabetic() {
                let mut j = i + 1;
                while j < n {
                    let c = chars[j];
                    if c.is_alphabetic() {
                        break;
                    }
                    j += 1;
                }
                let mut c = chars[i];
                let mut v = Vec::new();
                while i < j {
                    let mut s = String::new();
                    s.extend(chars[0..i].iter());
                    s.push(c);
                    s.extend(chars[i+1..j].iter());
                    s.extend(chars[j..].iter());
                    v.push(s);
                    if c.is_uppercase() {
                        c = c.to_lowercase().next().unwrap();
                    } else {
                        c = c.to_uppercase().next().unwrap();
                    }
                    i += 1;
                }
                res.append(&mut v);
            }
            i += 1;
        }
        if res.is_empty() {
            res.push(s);
        }
        res
    }
}