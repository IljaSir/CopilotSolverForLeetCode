impl Solution {
    pub fn num_subseq(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut l = 0;
        let mut r = nums.len() - 1;
        let mut res = 0;
        let mut modu = 1_000_000_007;
        let mut pows = vec![1];
        for i in 0..nums.len() {
            pows.push(pows[i] * 2 % modu);
        }
        while l <= r {
            if nums[l] + nums[r] > target {
                r -= 1;
            } else {
                res = (res + pows[r - l]) % modu;
                l += 1;
            }
        }
        res
    }
}