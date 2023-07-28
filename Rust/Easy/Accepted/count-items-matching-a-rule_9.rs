impl Solution {
    pub fn count_matches(items: Vec<Vec<String>>, rule_key: String, rule_value: String) -> i32 {
        
        let mut i = 0;
        for item in items {
            let mut j = 0;
            for field in item {
                if j == 0 {
                    if rule_key == "type" && rule_value == field {
                        i += 1;
                    }
                } else if j == 1 {
                    if rule_key == "color" && rule_value == field {
                        i += 1;
                    }
                } else {
                    if rule_key == "name" && rule_value == field {
                        i += 1;
                    }
                }
                j += 1;
            }
        }
        i
    }
}