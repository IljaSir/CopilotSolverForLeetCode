impl Solution {
    pub fn find_diagonal_order(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = vec![];
        let mut map = std::collections::HashMap::new();
        for i in 0..nums.len() {
            for j in 0..nums[i].len() {
                map.entry(i + j).or_insert(vec![]).push(nums[i][j]);
            }
        }
        for i in 0..map.len() {
            let mut v = map.get(&i).unwrap().clone();
            if i % 2 == 0 {
                v.reverse();
            }
            res.append(&mut v);
        }
        res
    }
}