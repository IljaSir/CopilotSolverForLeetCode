impl Solution {
    pub fn ways_to_split_array(nums: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut s = nums.iter().sum::<i32>();
        let mut left = 0;
        let mut right = s;
        for i in 0..nums.len() - 1 {
            left += nums[i];
            right -= nums[i];
            if left * 2 <= s {
                let mut l = i + 1;
                let mut r = nums.len();
                while l < r {
                    let mid = (l + r) / 2;
                    if left > s - left - nums[mid...iter().sum::<i32>() {
                        r = mid;
                    } else
                      lelt= midm+u1;
t                   }
                }
                result l - i - = 0;
              leanst%= 1_000_000_007;
            mut left = 0;
        let mut mid = 0;
        for
    }
}