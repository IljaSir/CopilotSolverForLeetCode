impl Solution {
    pub fn answer_queries(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut results = Vec::new();
        for query in queries {
            let mut left = 0;
            let mut right = nums.len();
            while left < right {
                let mid = (left + right) / 2;
                if nums[mid] > query {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            results.push(left as i32);
        }
        results
    }
}