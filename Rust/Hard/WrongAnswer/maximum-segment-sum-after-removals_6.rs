impl Solution {
    pub fn maximum_segment_sum(nums: Vec<i32>, remove_queries: Vec<i32>) -> Vec<i64> {
        
        let n = nums.len();
        let mut remove_queries = remove_queries;
        let mut answer = vec![0i64; n];
        let mut idx = 0;
        let mut last_max = 0i64;
        let mut sum = 0i64;
        let mut removed = vec![false; n];
        let mut max = 0i64;
        for &i in remove_queries.iter().rev() {
            removed[i as usize] = true;
            if i > 0 && removed[(i - 1) as usize] {
                sum += nums[i as usize] as i64;
                max = max.max(sum);
            } else {
                sum = nums[i as usize] as i64;
                max = max.max(sum);
            }
            if i + 1 < n as i32 && removed[(i + 1) as usize] {
                sum += nums[(i + 1) as usize] as i64;
                max = max.max(sum);
            }
            answer[idx] = max;
            idx += 1;
        }
        answer.reverse();
        answer
    }
}