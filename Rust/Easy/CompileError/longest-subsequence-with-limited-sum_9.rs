impl Solution {
    pub fn answer_queries(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut result: Vec<i32> = vec![];
        let mut prefix_sum: Vec<i32> = vec![0; nums.len() + 1];
        let mut index: usize = 1;
        for num in nums {
            prefix_sum[index] = prefix_sum[index - 1] + num;
            index += 1;
        }
        for query in queries {
            let mut left: usize = 0;
            let mut right: usize = nums.len();
            while left < right {
                let mid: usize = left + (right - left) / 2;
                if prefix_sum[mid + 1] <= query {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            result.push(left as i32);
        }
        result
    }
}