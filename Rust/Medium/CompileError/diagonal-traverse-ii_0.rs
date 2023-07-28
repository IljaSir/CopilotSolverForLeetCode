impl Solution {
    pub fn find_diagonal_order(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        for (i, row) in nums.iter().enumerate() {
            for (j, v) in row.iter().enumerate() {
                map.entry(i + j).or_insert(vec![]).push(v);
            }
        }
        let mut keys: Vec<_> = map.keys().collect();
        keys.sort();
        let mut res = vec![];
        for k in keys {
            for v in map.get(k).unwrap().iter().rev() {
                res.push(*v);
            }
        }
        res
    }
}