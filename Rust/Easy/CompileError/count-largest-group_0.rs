impl Solution {
    pub fn count_largest_group(n: i32) -> i32 {
        
        let mut count = vec![0; 37];
        for i in 1..=n {
            let mut j = i;
            let mut sum = 0;
            while j > 0 {
                sum += j % 10;
                j /= 10;
            }
            count[sum] += 1;
        }
        let mut max = 0;
        let mut res = 0;
        for i in 1..=36 {
            if count[i] > max {
                max = count[i];
                res = 1;
            } else if count[i] == max {
                res += 1;
            }
        }
        res
    }
}