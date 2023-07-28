impl Solution {
    pub fn moves_to_make_zigzag(nums: Vec<i32>) -> i32 {
        
        let len = nums.len();
        let mut a = nums.clone();
        let mut b = nums.clone();
        let mut ans = 0;
        for i in 0..len {
            let mut pre = 0;
            let mut post = 0;
            if i > 0 {
                pre = a[i-1];
            }
            if i+1 < len {
                post = a[i+1];
            }
            if pre >= a[i] || post >= a[i] {
                ans += (pre.max(post) - a[i] + 1).abs();
            }
            if i % 2 == 0 {
                a[i] = 1001;
            }
        }
        let mut tmp = 0;
        for i in 0..len {
            let mut pre = 0;
            let mut post = 0;
            if i > 0 {
                pre = b[i-1];
            }
            if i+1 < len {
                post = b[i+1];
            }
            if pre >= b[i] || post >= b[i] {
                tmp += (pre.max(post) - b[i] + 1).abs();
            }
            if i % 2 == 1 {
                b[i] = 1001;
            }
        }
        ans.min(tmp)
    }
}