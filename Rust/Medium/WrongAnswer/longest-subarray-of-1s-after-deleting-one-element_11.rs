impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut cnt = 0;
        let mut cnt1 = 0;
        for i in nums {
            if i == 1 {
                cnt1 += 1;
                cnt += 1;
            } else {
                max = max.max(cnt);
                cnt = cnt1;
                cnt1 = 0;
            }
        }
        max.max(cnt)
    }
}