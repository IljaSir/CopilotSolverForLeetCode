impl Solution {
    pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        for (i, l) in list1.iter().enumerate() {
            map.insert(l, i);
        }
        let mut min_sum = std::usize::MAX;
        let mut result = vec![];
        for (i, l) in list2.iter().enumerate() {
            if let Some(&j) = map.get(l) {
                let sum = i + j;
                if sum < min_sum {
                    min_sum = sum;
                    result = vec![l.clone()];
                } else if sum == min_sum {
                    result.push(l.clone());
                }
            }
        }
        result
    }
}