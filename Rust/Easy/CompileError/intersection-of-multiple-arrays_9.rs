impl Solution {
    pub fn intersection(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = Vec::new();
        let mut map = std::collections::HashMap::new();
        for num in nums.iter() {
            for i in num {
                if let Some(v) = map.get_mut(i) {
                    *v += 1;
                } else {
                    map.insert(i, 1);
                }
            }
        }
        for (k, v) in map {
            if *v == nums.len() {
                res.push(*k);
            }
        }
        res
    }
}