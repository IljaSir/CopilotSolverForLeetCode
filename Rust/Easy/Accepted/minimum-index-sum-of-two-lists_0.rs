impl Solution {
    pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {
        
        let mut map: std::collections::HashMap<String, usize> = std::collections::HashMap::new();
        for (i, s) in list1.iter().enumerate() {
            map.insert(s.to_string(), i);
        }
        let mut min_sum = usize::max_value();
        let mut result = Vec::new();
        for (i, s) in list2.iter().enumerate() {
            if let Some(&j) = map.get(s) {
                if i + j < min_sum {
                    min_sum = i + j;
                    result.clear();
                    result.push(s.to_string());
                } else if i + j == min_sum {
                    result.push(s.to_string());
                }
            }
        }
        result
    }
}