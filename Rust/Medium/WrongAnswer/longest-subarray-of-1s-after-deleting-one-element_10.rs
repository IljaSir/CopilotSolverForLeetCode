impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut count = 0;
        let mut prev = 0;
        for num in nums {
            if num == 1 {
                count += 1;
                continue;
            }
            ans = ans.max(count + prev);
            prev = count;
            count = 0;
        }
        ans.max(count + prev) - 1
    }
}