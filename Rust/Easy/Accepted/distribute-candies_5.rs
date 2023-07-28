impl Solution {
    pub fn distribute_candies(candy_type: Vec<i32>) -> i32 {
        
        let n = candy_type.len() / 2;
        let mut kinds = std::collections::HashSet::new();
        for &t in candy_type.iter() {
            kinds.insert(t);
            if kinds.len() >= n {
                break;
            }
        }
        kinds.len().min(n) as i32
    }
}