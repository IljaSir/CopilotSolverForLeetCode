impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, k: i32) -> i32 {
        
        let n = nums.len();
        let k = k as usize;
        let mut pos = vec![0; n + 1];
        for (i, &num) in nums.iter().enumerate() {
            pos[num as usize] = i;
        }
        let mut ans = 0;
        for i in 1..=n {
            let mut l = pos[i];
            let mut r = pos[i];
            while l > 0 && nums[l - 1] < i as i32 {
                l -= 1;
            }
            while r + 1 < n && nums[r + 1] < i as i32 {
                r += 1;
            }
            let mut ll = l;
            let mut rr = r;
            while ll > 0 && nums[ll - 1] == i as i32 {
                ll -= 1;
            }
            while rr + 1 < n && nums[rr + 1] == i as i32 {
                rr += 1;
            }
            if i < k {
                ans += (l - ll + 1) * (rr - r + 1);
            } else if i > k {
                ans += (ll - l + 1) * (r - rr + 1);
            } else {
                ans += (l - ll + 1) * (r - rr + 1);
            }
        }
        ans as i32
    }
}