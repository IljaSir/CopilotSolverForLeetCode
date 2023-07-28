impl Solution {
    pub fn longest_subarray(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut prev = 0;
        let mut cur = 0;
        for i in 0..nums.len() {
            if nums[i] == 1 {
                cur += 1;
            } else {
                prev = cur;
                cur = 0;
            }
            max = max.max(prev + cur);
        }
        max - 1

}
    }
}