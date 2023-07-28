impl Solution {
    pub fn find_best_value(arr: Vec<i32>, target: i32) -> i32 {
        
        let (mut l, mut r) = (0, *arr.iter().max().unwrap());
        while l < r {
            let m = l + (r - l) / 2;
            let sum = arr.iter().map(|&x| x.min(m)).sum();
            if sum < target {
                l = m + 1;
            } else {
                r = m;
            }
        }
        let (mut sum1, mut sum2) = (0, 0);
        for &x in &arr {
            let y = x.min(l);
            sum1 += y;
            sum2 += y.min(l - 1);
        }
        if (sum1 - target).abs() <= (sum2 - target).abs() {
            l
        } else {
            l - 1
        }
    }
}