impl Solution {
    pub fn answer_queries(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        let mut queries = queries;
        nums.sort();
        let mut res = vec![];
        for q in queries {
            let mut left = 0;
            let mut right = nums.len() - 1;
            let mut mid = 0;
            while left <= right {
                mid = (left + right) / 2;
                if nums[mid] > q {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if left == 0 {
                res.push(0);
            } else {
                res.push(left as i32);
            }
        }
        res
    }
}