impl Solution {
    pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {
        
        let mut min_sum = 2000;
        let mut result = vec![];
        for (i, a) in list1.iter().enumerate() {
            for (j, b) in list2.iter().enumerate() {
                if a == b {
                    if i + j < min_sum {
                        min_sum = i + j;
                        result = vec![a.to_string()];
                    } else if i + j == min_sum {
                        result.push(a.to_string());
                    }
                }
            }
        }
        result
    }
}