impl Solution {
    pub fn find_lhs(nums: Vec<i32>) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        for n in nums {
            let count = map.entry(n).or_insert(0);
            *count += 1;
        }
        let mut max = 0;
        for (k, v) in map.iter() {
            if let Some(v2) = map.get(&(k + 1)) {
                let sum = v + v2;
                if sum > max {
                    max = sum;
                }
            }
        }
        max
    }
}