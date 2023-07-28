impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        
        let mut map = std::collections::HashMap::new();
        for k in knowledge {
            map.insert(k[0].clone(), k[1].clone());
        }
        let mut res = String::new();
        let mut i = 0;
        while i < s.len() {
            if s[i..].starts_with('(') {
                let mut j = i + 1;
                while j < s.len() && s[j..].starts_with(')') == false {
                    j += 1;
                }
                if j < s.len() {
                    if let Some(k) = map.get(&s[i + 1..j]) {
                        res.push_str(k);
                    } else {
                        res.push('?');
                    }
                    i = j + 1;
                } else {
                    res.push('(');
                    i += 1;
                }
            } else {
                res.push(s[i..].chars().next().unwrap());
                i += 1;
            }
        }
        res
    }
}