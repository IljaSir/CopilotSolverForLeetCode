impl Solution {
    pub fn answer_queries(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut ans = Vec::new();
        let mut nums = nums;
        nums.sort();
        for q in queries {
            let mut l = 0;
            let mut r = nums.len() - 1;
            while l < r {
                let mid = l + (r - l + 1) / 2;
                if nums[mid] <= q {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            ans.push(if nums[l] <= q { l + 1 } else { l } as i32);
        }
        ans
    }
}