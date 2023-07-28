impl Solution {
    pub fn count_matches(items: Vec<Vec<String>>, rule_key: String, rule_value: String) -> i32 {
        
        let mut res = 0;
        let rule_idx = match rule_key.as_str() {
            "type" => 0,
            "color" => 1,
            "name" => 2,
            _ => 0,
        };
        for item in items {
            if item[rule_idx] == rule_value {
                res += 1;
            }
        }
        res
    }
}