impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        
        let mut map = std::collections::HashMap::new();
        for i in knowledge {
            map.insert(i[0].clone(), i[1].clone());
        }
        let mut res = String::new();
        let mut i = 0;
        while i < s.len() {
            if s[i..].starts_with('(') {
                let mut j = i + 1;
                while s[j..].starts_with('(') {
                    j += 1;
                }
                let mut k = j + 1;
                while s[k..].starts_with('(') {
                    k += 1;
                }
                res.push_str(map.get(&s[j..k]).unwrap_or(&"?".to_string()));
                i = k + 1;
            } else {
                res.push(s[i..].chars().next().unwrap());
                i += 1;
            }
        }
        res
    }
}