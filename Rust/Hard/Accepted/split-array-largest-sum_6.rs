impl Solution {
    pub fn split_array(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut l = 0;
        let mut r = 0;
        for i in &nums {
            l = l.max(*i);
            r += i;
        }
        while l < r {
            let mid = (l + r) >> 1;
            if Solution::check(&nums, k, mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        l
    }
    fn check(nums: &Vec<i32>, k: i32, t: i32) -> bool {
        let mut sum = 0;
        let mut cnt = 1;
        for i in nums {
            if sum + i > t {
                cnt += 1;
                sum = *i;
            } else {
                sum += i;
            }
        }
        cnt <= k
    }
}