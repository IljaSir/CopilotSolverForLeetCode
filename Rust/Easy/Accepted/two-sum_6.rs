impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        
        let mut hash = std::collections::HashMap::new();
        for (i, x) in nums.iter().enumerate() {
            if let Some(j) = hash.get(&(target - x)) {
                return vec![*j as i32, i as i32];
            }
            hash.insert(x, i);
        }
        vec![]
    }
}