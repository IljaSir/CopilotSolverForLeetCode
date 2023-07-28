impl Solution {
    pub fn ways_to_make_fair(nums: Vec<i32>) -> i32 {
        
        let n = nums.len();
        let mut odd = vec![0; n + 1];
        let mut even = vec![0; n + 1];
        for i in 0..n {
            if i & 1 == 0 {
                even[i + 1] = even[i] + nums[i];
                odd[i + 1] = odd[i];
            } else {
                odd[i + 1] = odd[i] + nums[i];
                even[i + 1] = even[i];
            }
        }
        let mut ans = 0;
        for i in 0..n {
            let mut tmp = 0;
            if i & 1 == 0 {
                tmp = even[i] + odd[n] - odd[i + 1];
            } else {
                tmp = odd[i] + even[n] - even[i + 1];
            }
            if tmp == even[n] - tmp {
                ans += 1;
            }
        }
        ans
    }
}