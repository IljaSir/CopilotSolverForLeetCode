impl Solution {
    pub fn distribute_candies(candy_type: Vec<i32>) -> i32 {
        
        let n = candy_type.len();
        let mut set = std::collections::HashSet::new();
        for candy in candy_type {
            set.insert(candy);
        }
        let m = set.len();
        if m >= n/2 {
            return n as i32 / 2;
        }
        return m as i32;
    }
}