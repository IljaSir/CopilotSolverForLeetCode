impl Solution {
    pub fn trap(height: Vec<i32>) -> i32 {
        
        let mut ans = 0;
        let mut left = 0;
        let mut right = height.len() - 1;
        let mut l_max = 0;
        let mut r_max = 0;
        while left < right {
            if height[left] < height[right] {
                if height[left] >= l_max {
                    l_max = height[left];
                } else {
                    ans += l_max - height[left];
                }
                left += 1;
            } else {
                if height[right] >= r_max {
                    r_max = height[right];
                } else {
                    ans += r_max - height[right];
                }
                right -= 1;
            }
        }
        ans
    }
}