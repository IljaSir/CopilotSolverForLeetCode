impl Solution {
    pub fn preimage_size_fzf(k: i32) -> i32 {
        
        let mut left = k;
        let mut right = k + 1;
        while Self::trailing_zeroes(left) == k {
            left *= 5;
        }
        while Self::trailing_zeroes(right) == k {
            right *= 5;
        }
        (right - left) / 5
    }
    
    fn trailing_zeroes(mut n: i32) -> i32 {
        let mut result = 0;
        while n > 0 {
            result += n / 5;
            n /= 5;
        }
        result
    }
}