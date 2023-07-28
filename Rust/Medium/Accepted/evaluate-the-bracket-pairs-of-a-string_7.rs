impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        
        let mut m = std::collections::HashMap::new();
        for i in knowledge {
            m.insert(i[0].clone(), i[1].clone());
        }
        let mut r = String::new();
        let mut i = 0;
        while i < s.len() {
            if s[i..].starts_with('(') {
                let mut j = i + 1;
                while s[j..].starts_with('(') {
                    j += 1;
                }
                let mut k = j + 1;
                while k < s.len() && !s[k..].starts_with(')') {
                    k += 1;
                }
                r.push_str(&m.get(&s[j..k]).unwrap_or(&"?".to_string()));
                i = k + 1;
            } else {
                r.push(s[i..].chars().next().unwrap());
                i += 1;
            }
        }
        r
    }
}