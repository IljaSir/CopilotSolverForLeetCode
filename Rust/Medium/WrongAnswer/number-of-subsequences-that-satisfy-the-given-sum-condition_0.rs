impl Solution {
    pub fn num_subseq(nums: Vec<i32>, target: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut l = 0;
        let mut r = nums.len() - 1;
        let mut res = 0;
        let mut p = 1;
        let mut modu = 1000000007;
        while l <= r {
            if nums[l] + nums[r] > target {
                r -= 1;
            } else {
                res = (res + p) % modu;
                l += 1;
                p = p * 2 % modu;
            }
        }
        res as i32
    }
}