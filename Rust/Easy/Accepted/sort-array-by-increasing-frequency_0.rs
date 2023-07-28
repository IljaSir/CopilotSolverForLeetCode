impl Solution {
    pub fn frequency_sort(nums: Vec<i32>) -> Vec<i32> {
        
        use std::collections::HashMap;
        let mut map: HashMap<i32, i32> = HashMap::new();
        for num in nums {
            let counter = map.entry(num).or_insert(0);
            *counter += 1;
        }
        let mut vec: Vec<(i32, i32)> = map.into_iter().collect();
        vec.sort_by(|a, b| {
            if a.1 == b.1 {
                b.0.cmp(&a.0)
            } else {
                a.1.cmp(&b.1)
            }
        });
        let mut res = Vec::new();
        for (num, count) in vec {
            for _ in 0..count {
                res.push(num);
            }
        }
        res
    }
}