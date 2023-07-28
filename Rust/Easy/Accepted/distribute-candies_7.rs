impl Solution {
    pub fn distribute_candies(candy_type: Vec<i32>) -> i32 {
        
        let n = candy_type.len() as i32 / 2;
        let mut kinds = std::collections::HashSet::new();
        for t in candy_type {
            kinds.insert(t);
        }
        let kinds = kinds.len() as i32;
        if kinds < n {
            kinds
        } else {
            n
        }
    }
}