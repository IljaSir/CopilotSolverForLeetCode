impl Solution {
    pub fn count_matches(items: Vec<Vec<String>>, rule_key: String, rule_value: String) -> i32 {
        
        let mut count = 0;
        let (key, value) = match rule_key.as_str() {
            "type" => (0, rule_value),
            "color" => (1, rule_value),
            "name" => (2, rule_value),
            _ => (0, rule_value),
        };
        for item in items {
            if item[key] == value {
                count += 1;
            }
        }
        return count;
    }
}