impl Solution {
    pub fn answer_queries(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort_unstable();
        let mut res = Vec::new();
        for &q in &queries {
            res.push(nums.binary_search_by(|&x| x.cmp(&q)).unwrap_or_else(|e| e) as i32);
        }
        res
    }
}