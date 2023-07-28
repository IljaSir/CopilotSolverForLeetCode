impl Solution {
    pub fn count_matches(items: Vec<Vec<String>>, rule_key: String, rule_value: String) -> i32 {
        
        let mut count = 0;
        for item in items {
            let mut flag = false;
            if rule_key == "type" {
                if item[0] == rule_value {
                    flag = true;
                }
            } else if rule_key == "color" {
                if item[1] == rule_value {
                    flag = true;
                }
            } else if rule_key == "name" {
                if item[2] == rule_value {
                    flag = true;
                }
            }
            if flag {
                count += 1;
            }
        }
        count
    }
}