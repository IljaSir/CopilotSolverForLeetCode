impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        
        let mut knowledge_map = std::collections::HashMap::new();
        for pair in knowledge {
            knowledge_map.insert(pair[0].clone(), pair[1].clone());
        }
        let mut result = String::new();
        let mut i = 0;
        while i < s.len() {
            let c = s.chars().nth(i).unwrap();
            if c == '(' {
                let mut key = String::new();
                i += 1;
                while i < s.len() {
                    let c = s.chars().nth(i).unwrap();
                    if c == ')' {
                        break;
                    }
                    key.push(c);
                    i += 1;
                }
                if let Some(value) = knowledge_map.get(&key) {
                    result.push_str(value);
                } else {
                    result.push('?');
                }
            } else {
                result.push(c);
            }
            i += 1;
        }
        result
    }
}