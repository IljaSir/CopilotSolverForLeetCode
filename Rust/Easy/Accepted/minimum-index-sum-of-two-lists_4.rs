impl Solution {
    pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {
        
        let mut map = std::collections::HashMap::new();
        for i in 0..list1.len() {
            map.insert(list1[i].to_string(), i);
        }
        let mut min = std::usize::MAX;
        let mut ret = Vec::new();
        for i in 0..list2.len() {
            if let Some(&j) = map.get(&list2[i]) {
                let sum = i + j;
                if sum < min {
                    min = sum;
                    ret.clear();
                    ret.push(list2[i].to_string());
                } else if sum == min {
                    ret.push(list2[i].to_string());
                }
            }
        }
        ret
    }
}