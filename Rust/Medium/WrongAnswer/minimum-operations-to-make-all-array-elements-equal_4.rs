impl Solution {
    pub fn min_operations(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i64> {
        
        let mut nums = nums;
        let mut queries = queries;
        let mut res = Vec::new();
        nums.sort();
        for i in 0..queries.len() {
            let mut count = 0;
            for j in 0..nums.len() {
                if nums[j] < queries[i] {
                    count += 1;
                } else {
                    break;
                }
            }
            let mut count2 = 0;
            for j in (0..nums.len()).rev() {
                if nums[j] > queries[i] {
                    count2 += 1;
                } else {
                    break;
                }
            }
            res.push((count * (nums.len() - count) + count2 * (nums.len() - count2)) as i64);
        }
        res
    }
}