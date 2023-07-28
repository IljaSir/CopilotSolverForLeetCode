impl Solution {
    pub fn minimized_maximum(n: i32, quantities: Vec<i32>) -> i32 {
        
        let n = n as usize;
        let mut quantities = quantities;
        quantities.sort();
        quantities.reverse();
        let mut l = 1;
        let mut r = quantities[0];
        let mut ans = r;
        while l <= r {
            let mid = (l + r) / 2;
            let mut sum = 0;
            for &q in quantities.iter() {
                if sum >= n {
                    break;
                }
                sum += q / mid;
            }
            if sum >= n {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        ans
    }
}