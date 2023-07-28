impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        
        let mut s = s.chars().collect::<Vec<_>>();
        let mut i = 0;
        let mut map = std::collections::HashMap::new();
        for a in knowledge {
            map.insert(a[0].clone(), a[1].clone());
        }
        while i < s.len() {
            if s[i] == '(' {
                let mut j = i + 1;
                while s[j] != ')' {
                    j += 1;
                }
                let key = s[i + 1..j].iter().collect::<String>();
                if let Some(value) = map.get(&key) {
                    s[i..=j].clone_from_slice(value.as_bytes());
                } else {
                    s[i..=j].clone_from_slice(b"?");
                }
                i += value.len();
            } else {
                i += 1;
            }
        }
        s.iter().collect()
    }
}