impl Solution {
    pub fn count_largest_group(n: i32) -> i32 {
        
        let mut sum = vec![0; 37];
        for i in 1..=n {
            let mut j = i;
            let mut s = 0;
            while j > 0 {
                s += j % 10;
                j /= 10;
            }
            sum[s] += 1;
        }
        let mut max = 0;
        let mut res = 0;
        for i in 1..=36 {
            if sum[i] == max {
                res += 1;
            } else if sum[i] > max {
                max = sum[i];
                res = 1;
            }
        }
        res
    }
}