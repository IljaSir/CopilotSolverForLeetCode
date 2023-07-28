impl Solution {
    pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        let mut min_sum = list1.len() + list2.len();
        let mut res = vec![];
        for (i, s) in list1.iter().enumerate() {
            map.insert(s, i);
        }
        for (i, s) in list2.iter().enumerate() {
            if let Some(j) = map.get(s) {
                if i + j == min_sum {
                    res.push(s.clone());
                } else if i + j < min_sum {
                    min_sum = i + j;
                    res = vec![s.clone()];
                }
            }
        }
        res
    }
}