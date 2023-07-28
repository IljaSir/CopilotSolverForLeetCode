impl Solution {
    pub fn min_operations(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i64> {
        
        let mut nums = nums;
        let mut queries = queries;
        let mut ans = vec![];
        nums.sort();
        for q in queries {
            let mut count = 0;
            let mut i = 0;
            let mut j = nums.len() - 1;
            while i < nums.len() {
                if nums[i] < q {
                    count += (j - i) as i64;
                    i += 1;
                } else {
                    break;
                }
            }
            while j >= 0 {
                if nums[j] > q {
                    count += (j - i) as i64;
                    j -= 1;
                } else {
                    break;
                }
            }
            ans.push(count);
        }
        ans
    }
}