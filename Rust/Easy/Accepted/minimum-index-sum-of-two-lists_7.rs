impl Solution {
    pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        let mut min = std::i32::MAX;
        for (i, item) in list1.iter().enumerate() {
            map.insert(item, i as i32);
        }
        let mut res = Vec::new();
        for (i, item) in list2.iter().enumerate() {
            if let Some(&j) = map.get(item) {
                if i as i32 + j < min {
                    min = i as i32 + j;
                    res.clear();
                    res.push(item.clone());
                } else if i as i32 + j == min {
                    res.push(item.clone());
                }
            }
        }
        res
    }
}