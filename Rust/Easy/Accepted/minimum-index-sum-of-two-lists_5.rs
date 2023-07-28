impl Solution {
    pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {
        
        let mut min = std::usize::MAX;
        let mut result = Vec::new();
        for (i, s1) in list1.iter().enumerate() {
            for (j, s2) in list2.iter().enumerate() {
                if s1 == s2 {
                    let sum = i + j;
                    if sum < min {
                        min = sum;
                        result.clear();
                        result.push(s1.clone());
                    } else if sum == min {
                        result.push(s1.clone());
                    }
                }
            }
        }
        result
    }
}