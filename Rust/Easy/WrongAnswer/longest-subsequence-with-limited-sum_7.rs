impl Solution {
    pub fn answer_queries(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut queries = queries;
        let mut nums = nums;
        nums.sort();
        queries.sort();
        let mut res = Vec::new();
        let mut j = 0;
        for i in 0..queries.len() {
            while j < nums.len() && nums[j] <= queries[i] {
                j += 1;
            }
            res.push(j as i32);
        }
        res
    }
}