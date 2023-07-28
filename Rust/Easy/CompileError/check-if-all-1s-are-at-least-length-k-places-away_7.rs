impl Solution {
    pub fn k_length_apart(nums: Vec<i32>, k: i32) -> bool {
        
        let mut ans = true;
        let mut last = -1;
        for (i, &x) in nums.iter().enumerate() {
            if x == 1 {
                if last != -1 && i - last - 1 < k {
                    ans = false;
                    break;
                }
                last = i as i32;
            }
        }
        ans
    }
}