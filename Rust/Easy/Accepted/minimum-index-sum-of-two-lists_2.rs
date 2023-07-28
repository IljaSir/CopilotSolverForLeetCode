impl Solution {
    pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        for (i, s) in list1.iter().enumerate() {
            map.insert(s, i);
        }
        let mut min = std::usize::MAX;
        let mut result = Vec::new();
        for (i, s) in list2.iter().enumerate() {
            if let Some(&j) = map.get(s) {
                if i + j < min {
                    min = i + j;
                    result = vec![s.clone()];
                } else if i + j == min {
                    result.push(s.clone());
                }
            }
        }
        result
    }
}