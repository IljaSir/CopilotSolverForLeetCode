impl Solution {
    pub fn maximum_segment_sum(nums: Vec<i32>, remove_queries: Vec<i32>) -> Vec<i64> {
        
        let mut nums = nums;
        let mut remove_queries = remove_queries;
        let mut res = vec![0; remove_queries.len()];
        let mut max = 0;
        let mut sum = 0;
        let mut removed = vec![false; nums.len()];
        for i in 0..nums.len() {
            sum += nums[i];
            max = std::cmp::max(max, sum);
        }
        for i in 0..remove_queries.len() {
            let idx = remove_queries[i] as usize;
            removed[idx] = true;
            if idx > 0 && !removed[idx - 1] {
                let mut tmp = nums[idx];
                let mut j = idx + 1;
                while j < nums.len() && !removed[j] {
                    tmp += nums[j];
                    j += 1;
                }
                max = std::cmp::max(max, tmp);
            }
            if idx < nums.len() - 1 && !removed[idx + 1] {
                let mut tmp = nums[idx];
                let mut j = idx - 1;
                while j >= 0 && !removed[j] {
                    tmp += nums[j];
                    j -= 1;
                }
                max = std::cmp::max(max, tmp);
            }
            res[i] = max;
        }
        res
    }
}