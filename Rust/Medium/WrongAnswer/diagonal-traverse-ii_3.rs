impl Solution {
    pub fn find_diagonal_order(nums: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut map = std::collections::HashMap::new();
        for (i, row) in nums.iter().enumerate() {
            for (j, &n) in row.iter().enumerate() {
                map.entry(i + j).or_insert(Vec::new()).push(n);
            }
        }
        let mut ans = Vec::new();
        for (k, v) in map.iter() {
            if k % 2 == 0 {
                ans.extend(v.iter().rev());
            } else {
                ans.extend(v.iter());
            }
        }
        ans
    }
}