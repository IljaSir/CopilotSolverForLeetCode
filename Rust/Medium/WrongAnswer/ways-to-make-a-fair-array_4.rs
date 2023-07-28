impl Solution {
    pub fn ways_to_make_fair(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut odds = vec![0; n];
        let mut evens = vec![0; n];
        let mut odd = 0;
        let mut even = 0;
        for i in (0..n).rev() {
            if i % 2 == 0 {
                even += nums[i];
                evens[i] = even;
            } else {
                odd += nums[i];
                odds[i] = odd;
            }
        }
        odd = 0;
        even = 0;
        let mut ans = 0;
        for i in 0..n {
            if i % 2 == 0 {
                even += nums[i];
            } else {
                odd += nums[i];
            }
            let mut e = even;
            let mut o = odd;
            if i + 1 < n {
                e += odds[i + 1];
                o += evens[i + 1];
            }
            if e == o {
                ans += 1;
            }
        }
        ans
    }
}