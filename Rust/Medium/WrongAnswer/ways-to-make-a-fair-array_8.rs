impl Solution {
    pub fn ways_to_make_fair(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut odd = 0;
        let mut even = 0;
        let mut odd_pre = vec![0; nums.len()];
        let mut even_pre = vec![0; nums.len()];
        for i in 0..nums.len() {
            if i % 2 == 0 {
                even += nums[i];
                even_pre[i] = even;
                odd_pre[i] = odd;
            } else {
                odd += nums[i];
                even_pre[i] = even;
                odd_pre[i] = odd;
            }
        }
        let mut odd = 0;
        let mut even = 0;
        let mut odd_post = vec![0; nums.len()];
        let mut even_post = vec![0; nums.len()];
        for i in (0..nums.len()).rev() {
            if i % 2 == 0 {
                even += nums[i];
                even_post[i] = even;
                odd_post[i] = odd;
            } else {
                odd += nums[i];
                even_post[i] = even;
                odd_post[i] = odd;
            }
        }
        for i in 0..nums.len() {
            let mut o = 0;
            let mut e = 0;
            if i == 0 {
                o = odd_post[i + 1];
                e = even_post[i + 1];
            } else if i == nums.len() - 1 {
                o = odd_pre[i - 1];
                e = even_pre[i - 1];
            } else {
                o = odd_pre[i - 1] + odd_post[i + 1];
                e = even_pre[i - 1] + even_post[i + 1];
            }
            if o == e {
                ans += 1;
            }
        }
        ans
    }
}