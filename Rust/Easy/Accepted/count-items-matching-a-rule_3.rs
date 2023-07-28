impl Solution {
    pub fn count_matches(items: Vec<Vec<String>>, rule_key: String, rule_value: String) -> i32 {
        
        let mut count = 0;
        let mut index = 0;
        if rule_key == "color" {
            index = 1;
        } else if rule_key == "name" {
            index = 2;
        }
        for item in items {
            if item[index] == rule_value {
                count += 1;
            }
        }
        count
    }
}