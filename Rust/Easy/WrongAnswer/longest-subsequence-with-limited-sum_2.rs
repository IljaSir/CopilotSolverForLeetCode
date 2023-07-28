impl Solution {
    pub fn answer_queries(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut res = Vec::new();
        for q in queries {
            let mut left = 0;
            let mut right = nums.len() - 1;
            while left <= right {
                let mid = left + (right - left) / 2;
                if nums[mid] <= q {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            res.push(left as i32);
        }
        res
    }
}