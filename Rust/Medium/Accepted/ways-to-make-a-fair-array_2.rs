impl Solution {
    pub fn ways_to_make_fair(nums: Vec<i32>) -> i32 {
        
        let mut odd = 0;
        let mut even = 0;
        for (i, &num) in nums.iter().enumerate() {
            if i % 2 == 0 {
                even += num;
            } else {
                odd += num;
            }
        }
        let mut ans = 0;
        let mut odd2 = 0;
        let mut even2 = 0;
        for (i, &num) in nums.iter().enumerate() {
            if i % 2 == 0 {
                even -= num;
                if odd2 + even == odd + even2 {
                    ans += 1;
                }
                even2 += num;
            } else {
                odd -= num;
                if odd2 + even == odd + even2 {
                    ans += 1;
                }
                odd2 += num;
            }
        }
        ans
    }
}