impl Solution {
    pub fn min_operations(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i64> {
        
        let mut res = vec![0; queries.len()];
        let mut nums = nums;
        nums.sort();
        let mut count = vec![0; nums.len() + 1];
        for i in 1..count.len() {
            count[i] = count[i - 1] + nums[i - 1];
        }
        for (i, q) in queries.iter().enumerate() {
            let idx = nums.binary_search(q).unwrap_or_else(|x| x);
            res[i] = (idx as i64) * q as i64 - count[idx] + count[nums.len()] - count[idx] - (nums.len() as i64 - idx as i64) * q as i64;
        }
        res
    }
}