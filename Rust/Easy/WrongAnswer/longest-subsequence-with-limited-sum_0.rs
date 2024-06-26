impl Solution {
    pub fn answer_queries(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut ans = Vec::new();
        for q in queries {
            let mut l = 0;
            let mut r = nums.len();
            while l < r {
                let m = l + (r - l) / 2;
                if nums[m] <= q {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            ans.push(l as i32);
        }
        ans
    }
}