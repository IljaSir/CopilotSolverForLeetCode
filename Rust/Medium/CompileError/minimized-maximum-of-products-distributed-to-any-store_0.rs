impl Solution {
    pub fn minimized_maximum(n: i32, quantities: Vec<i32>) -> i32 {
        
        let n = n as usize;
        let mut left = 1;
        let mut right = quantities.iter().sum::<i32>();
        while left < right {
            let mid = (left + right) / 2;
            if Solution::can_distribute(mid, n, &quantities) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
    fn can_distribute(x: i32, n: usize, quantities: &Vec<i32>) -> bool {
        let mut count = 0;
        for &quantity in quantities {
            count += (quantity - 1) / x + 1;
        }
        count <= n
    }
}