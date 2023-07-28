impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        
        let mut map: std::collections::HashMap<i32, i32> = std::collections::HashMap::new();
        for (i, n) in nums.iter().enumerate() {
            let t = target - n;
            if map.contains_key(&t) {
                return vec![*map.get(&t).unwrap(), i as i32];
            }
            map.insert(*n, i as i32);
        }
        vec![]
    }
}