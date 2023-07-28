impl Solution {
    pub fn find_diagonal_order(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        for (i, row) in nums.iter().enumerate() {
            for (j, &num) in row.iter().enumerate() {
                map.entry(i + j).or_insert_with(Vec::new).push(num);
            }
        }
        let mut ans = Vec::new();
        for i in 0..=map.len() {
            if let Some(v) = map.get(&i) {
                ans.extend(v.iter().rev());
            }
        }
        ans
    }
}