impl Solution {
    pub fn minimized_maximum(n: i32, quantities: Vec<i32>) -> i32 {
        
        let mut quantities = quantities;
        let n = n as usize;
        let m = quantities.len();
        quantities.sort();
        let mut left = 1;
        let mut right = quantities[m - 1];
        let mut ans = right;
        while left <= right {
            let mid = (left + right) / 2;
            let mut total = 0;
            for i in 0..m {
                total += quantities[i] / mid;
                if total >= n {
                    break;
                }
            }
            if total >= n {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        ans
    }
}