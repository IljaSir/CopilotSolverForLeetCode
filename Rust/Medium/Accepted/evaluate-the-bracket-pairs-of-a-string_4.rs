impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        
        let mut map = std::collections::HashMap::new();
        for k in knowledge {
            map.insert(k[0].clone(), k[1].clone());
        }
        let mut ret = String::new();
        let mut i = 0;
        while i < s.len() {
            if s[i..].starts_with('(') {
                let mut j = i + 1;
                while s[j..].starts_with(')') == false {
                    j += 1;
                }
                let key = &s[i + 1..j];
                match map.get(key) {
                    Some(v) => ret.push_str(v),
                    None => ret.push('?'),
                }
                i = j + 1;
            } else {
                ret.push(s[i..].chars().next().unwrap());
                i += 1;
            }
        }
        ret
    }
}